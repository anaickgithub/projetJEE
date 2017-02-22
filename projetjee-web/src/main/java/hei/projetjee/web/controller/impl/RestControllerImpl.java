package hei.projetjee.web.controller.impl;

import hei.projetJEE.service.URLPersoService;
import hei.projetjee.web.controller.RestController;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Anaïck on 22/02/2017.
 */
@Named
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestControllerImpl implements RestController {

    @Inject
    private URLPersoService urlPersoService;
}
