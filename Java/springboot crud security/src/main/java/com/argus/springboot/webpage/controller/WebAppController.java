/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.webpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author nihar
 */
@Controller
public class WebAppController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    @GetMapping("/extra")
    public String showExtra() {

        return "index";
    }

    @GetMapping("/loginPage")
    public String showLoginPage() {

        return "login";
    }

    @GetMapping("/accessdenied")
    public String showErrorPage() {

        return "accessdenied";
    }
}
