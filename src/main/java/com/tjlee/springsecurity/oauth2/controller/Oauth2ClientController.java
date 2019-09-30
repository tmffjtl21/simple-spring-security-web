package com.tjlee.springsecurity.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

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
    public String login(Model model, Principal principal, @RequestParam(required = false) String code, HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        model.addAttribute("name", Optional.ofNullable(principal).map(Principal::getName).orElse(null));
        model.addAttribute("code", code);
        return "oauth/login";
    }
}
