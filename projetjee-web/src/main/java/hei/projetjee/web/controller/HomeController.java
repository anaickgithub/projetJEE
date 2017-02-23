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


    // ------------- A FAIRE ------------- //

    @RequestMapping(value = "/addurl", method = RequestMethod.POST)
    public String addURL(@ModelAttribute("url") URLPerso urlperso){
        LOGGER.info("J'ajoute un url");
        urlPersoservice.save(urlperso);
        return "redirect:home";
    }

}
