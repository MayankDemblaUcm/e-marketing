package com.ucm.adbms.controller;

import com.ucm.adbms.model.LoginModel;
import com.ucm.adbms.model.UserModel;
import com.ucm.adbms.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@ControllerAdvice
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService ;

    @GetMapping("/login")
    public String loginForm(Model model, HttpSession session) {

        model.addAttribute("user", new LoginModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginModel user, Model model, HttpSession session) {

        log.info("Inside POST login() with Input User : {}", user);

        String typeOfUser = userService.identifyUser(user.getEmail()) ;

        return "signup";
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
