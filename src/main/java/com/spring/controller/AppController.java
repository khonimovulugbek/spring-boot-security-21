package com.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AppController {
    @GetMapping
    public String checkSecurity(HttpServletRequest request) {
           return "Spring security | session id is " + request.getSession().getId();
    }
}
