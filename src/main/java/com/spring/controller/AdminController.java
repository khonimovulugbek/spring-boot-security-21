package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Khonimov Ulugbek
 * Date: 10/13/2024 11:51 AM
 * Info:
 */
@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping("test")
    public String test(){
        return "test admin";
    }
}
