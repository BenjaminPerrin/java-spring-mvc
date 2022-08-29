/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ben
 */
@Controller
public class HelloController {
    
   @GetMapping({"/", "/hello"})
    public String showWelcomePage(ModelMap model) {
        model.addAttribute("title", "Mon app MVC");
        model.addAttribute("message", "Hello depuis Spring MVC");
        return "hello";
    }
}
