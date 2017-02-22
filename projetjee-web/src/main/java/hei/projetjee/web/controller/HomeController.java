package hei.projetjee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anaïck on 22/02/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String goHome(){
        return "home";
    }
}
