package hei.projetjee.web.controller;

import hei.projetjee.entity.URLPerso;
import hei.projetjee.service.URLPersoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Anaïck on 22/02/2017.
 */
@Controller
public class HomeController{

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Inject
    private URLPersoService urlPersoservice;

    @RequestMapping({"/","/home"})
    public String goHome(ModelMap model){
        URLPerso lastURLPerso = urlPersoservice.getLastURLPerso();
        if(lastURLPerso==null) URLPerso.newURL ="`";
        else URLPerso.newURL = lastURLPerso.getUrlCourt();
        LOGGER.info("Je retourne la liste des url");
        List<URLPerso> listurlperso = urlPersoservice.findAll();
        model.addAttribute("listurlperso",listurlperso);
        return "home";
    }

    @RequestMapping(value="/delete/{idURL:\\d+}", method = RequestMethod.POST)
    public String deleteURL(@PathVariable("idURL") long id){
        urlPersoservice.delete(id);
        return "redirect:../home";
    }

    @RequestMapping(value = "/addurl", method = RequestMethod.POST)
    public String addURL(@ModelAttribute("url") URLPerso urlPerso){
        URLPerso check = urlPersoservice.findOneByUrl(urlPerso.getUrl());
        if(check==null) {
            if (urlPerso.getUrlCourt() != "" && urlPerso.getUrlCourt() != null) urlPerso.setPerso(true);
            else {
                urlPerso.raccourcir();
                urlPerso.setUrlCourt(URLPerso.newURL);
                urlPerso.setPerso(false);
            }
            LOGGER.info("J'ajoute un url");
            urlPersoservice.save(urlPerso);
        }
        return "redirect:home";
    }

    @RequestMapping(value="/{urlCourt}")
    public String goToURL(@PathVariable("urlCourt") String urlCourt){

        URLPerso urlPerso = urlPersoservice.findOneByUrlCourt(urlCourt);
        if(urlPerso!=null)
            return "redirect:"+urlPerso.getUrl();
        else return "redirect:home";
    }
}
