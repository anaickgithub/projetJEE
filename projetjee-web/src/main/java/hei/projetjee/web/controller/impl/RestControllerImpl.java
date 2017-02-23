package hei.projetjee.web.controller.impl;

import hei.projetjee.entity.URL;
import hei.projetjee.entity.URLPerso;
import hei.projetjee.service.URLPersoService;
import hei.projetjee.web.controller.RestController;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Anaïck on 22/02/2017.
 */
@Named
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestControllerImpl implements RestController {

    @Inject
    private URLPersoService urlPersoService;

    @GET
    @Path("/api/list")
    public List<URLPerso> getList() {
        return urlPersoService.findAll();
    }

    @POST
    @Path("/api")
    public URLPerso add(URL url) {

        URLPerso newUrl = new URLPerso(url.getUrl());
        newUrl.raccourcir();
        newUrl.setUrlCourt(URLPerso.newURL);
        urlPersoService.save(newUrl);
        return newUrl;
    }

    @GET
    @Path("/")
    public String lastURL() {
        URLPerso.newURL = urlPersoService.getLastURLPerso().getUrlCourt();
        return URLPerso.newURL;
    }
}
