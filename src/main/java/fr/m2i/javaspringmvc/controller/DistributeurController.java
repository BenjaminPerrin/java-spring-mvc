/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.controller;

import fr.m2i.javaspringmvc.form.BuyForm;
import fr.m2i.javaspringmvc.form.UserForm;
import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.service.ProductService;
import fr.m2i.javaspringmvc.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @PostMapping("addBalance")
    public String addBalance(@ModelAttribute("UserForm") @Valid UserForm user,
            BindingResult result, ModelMap model) throws Exception{
        
        if (result.hasErrors()) {
            return "distributeur";
        }
        //model.addAttribute("balance", user.getBalance()+userService.getBalance());
        //userService.setBalance(user.getBalance()+userService.getBalance());
        //return "redirect:distributeur";
        try {
            userService.addBalance(user.getBalance());
            return "redirect:distributeur";
        } catch (Exception e) {
            result.rejectValue("balance", null, "Une erreur est survenue lors de l'ajout de crédit");
            return "distributeur";
        }
    }
    
    @PostMapping("buyProduct")
    public String buyProduct(@ModelAttribute("BuyForm") @Valid BuyForm buyform,
            BindingResult result, ModelMap model) throws Exception{
        
        if (result.hasErrors()) {
            return "distributeur";
        }
        //model.addAttribute("balance", user.getBalance()+userService.getBalance());
        //userService.setBalance(user.getBalance()+userService.getBalance());
        //return "redirect:distributeur";
        try {
//            userService.
            return "redirect:distributeur";
        } catch (Exception e) {
            result.rejectValue("products", null, "Une erreur est survenue lors de l'achat");
            return "distributeur";
        }
    }
    
    @ModelAttribute("listProducts")
    public List<Product> findAll() throws Exception{
        return productService.findAll();
    }
    
    @ModelAttribute("balance")
    public Double addBalanceBean() {
        try {
            return userService.getBalance();
        } catch (Exception e) {
            // log user not found
            return 0.0;
        }
    }
    
    @ModelAttribute("products")
    public List<Product> addProductsBean() throws Exception {
        try {
            return productService.findAll();
        } catch (Exception e) {
            // log no products in database
            return new ArrayList();
        }
    }
    
    @ModelAttribute("userForm")
    public UserForm addUserForm() {
        return new UserForm();
    }
    
    @ModelAttribute("buyForm")
    public BuyForm addBuyForm() {
        return new BuyForm();
    }
}
