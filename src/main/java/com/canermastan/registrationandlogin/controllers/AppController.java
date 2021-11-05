package com.canermastan.registrationandlogin.controllers;

import com.canermastan.registrationandlogin.model.User;
import com.canermastan.registrationandlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.stereotype.Controller
public class AppController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value = "/process_register", method = RequestMethod.POST)
    public String processRegister(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        this.userService.save(user);
        return "register_success";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String userList(Model model){
        List<User> users = this.userService.findAll();
        model.addAttribute("userList",users);
        return "users";
    }

}
