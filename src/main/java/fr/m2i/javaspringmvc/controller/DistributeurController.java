/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.controller;

import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.service.ProductService;
import fr.m2i.javaspringmvc.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author ben
 */
@Controller
public class DistributeurController {
    private final UserService userService;
    private final ProductService productService;
    
    @Autowired
    public DistributeurController(UserService userService, ProductService productService){
        this.userService = userService;
        this.productService = productService;
    }
    
    @GetMapping("/distributeur")
    public String showDistributeurPage(){
        return "distributeur";
    }
    
    @ModelAttribute("balance")
    public Double addBalanceBean() throws Exception{
        return userService.getBalance();
    }
    
    @ModelAttribute("products")
    public List<Product> addProductsBean() throws Exception{
        return productService.findAll();
    }
}
