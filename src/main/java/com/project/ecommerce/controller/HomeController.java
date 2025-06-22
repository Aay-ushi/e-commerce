package com.project.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private AuthenticationManager authManager;


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "missing", required = false) String missing,
                            Model model) {
        if (error != null) model.addAttribute("error", "Invalid username or password.");
        if (missing != null) model.addAttribute("missing", "Username and password are required.");
        return "login"; // loads login.html
    }

    // @PostMapping("/custom-login")
    // public String loginSubmit(HttpServletRequest request) {
    //     String username = request.getParameter("username");
    //     String password = request.getParameter("password");

    //     if (username == null || username.isEmpty()) {
    //         return "redirect:/login?missing=username";
    //     }
    //     else if(password == null || password.isBlank()){
    //         return "redirect:/login?missing=password";
    //     }

    //     try {
    //         Authentication auth = authManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(username, password));
    //         // Successful login → redirect to home
    //         return "redirect:/home";
    //     } catch (AuthenticationException e) {
    //         return "redirect:/login?error=true";
    //     }
    // }

}