package com.ucm.adbms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucm.adbms.entity.Admin;
import com.ucm.adbms.entity.Customer;
import com.ucm.adbms.entity.Product;
import com.ucm.adbms.entity.Vendor;
import com.ucm.adbms.model.LoginModel;
import com.ucm.adbms.model.UserModel;
import com.ucm.adbms.service.ProductService;
import com.ucm.adbms.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@ControllerAdvice
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService ;

    @Autowired
    private ProductService productService ;

    @GetMapping("/login")
    public String loginForm(Model model, HttpSession session) {

        model.addAttribute("user", new LoginModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginModel user, Model model, HttpSession session) {

        log.info("Inside POST login() with Input User : {}", user);

        Object typeOfUser = userService.identifyUser(user.getEmail()) ;

        if(typeOfUser instanceof Admin){
            model.addAttribute("admin", (Admin) typeOfUser) ;
            return "admin" ; // load admin page
        }else if(typeOfUser instanceof Customer){

            model.addAttribute("customer", (Customer) typeOfUser) ;

            // products
            List<Product> products = productService.fetchAllProducts() ;
            model.addAttribute("products", products) ;

            return "customer" ;
        }else if(typeOfUser instanceof Vendor){
            return "vendor" ;
        }

        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model, HttpSession session) {

        model.addAttribute("user", new UserModel());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserModel user, Model model,
                         @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {

        return "verifycode";
    }
}
