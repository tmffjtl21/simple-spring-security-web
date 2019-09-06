package com.tjlee.springsecurity.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/oauth")
public class Oauth2ClientController {

    @GetMapping("/main")
    public String main(){
        return "oauth/main";
    }

    @GetMapping("/get-code")
    public String getCode(Model model, Principal principal){
//        model.addAttribute("message", "Hello Admin, " + principal.getName());

        model.addAttribute("test", "test1111");
        return "oauth/get-code";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String code){
        model.addAttribute("code", code);
        return "oauth/login";
    }
}
