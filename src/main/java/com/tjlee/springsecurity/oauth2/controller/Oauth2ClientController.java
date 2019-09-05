package com.tjlee.springsecurity.oauth2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
@RequestMapping("/oauth")
public class Oauth2ClientController {

    @GetMapping("/")
    public String main(){
        return "oauth/main";
    }

    @GetMapping("/get-code")
    public String getCode(Model model, Principal principal){
//        model.addAttribute("message", "Hello Admin, " + principal.getName());

        model.addAttribute("test", "test1111");
        return "oauth/get-code";
    }
}
