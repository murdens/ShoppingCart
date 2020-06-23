package com.murdens.cmsshoppingcart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
// This has just been left to show can return a view in this way.  Home view returned in WebConfig.
    @GetMapping("/someRandomPage")
    public String home(){
        // will return a view file - home
        return "home";
    }
}