package com.spring.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details above and click login");
        return "login";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginClass") LoginClass loginClass) {
        if (loginClass != null && loginClass.getUsername() != null & loginClass.getPassword() != null) {
            if (loginClass.getUsername().equals("kiran") && loginClass.getPassword().equals("kiran")) {
                model.addAttribute("msg", loginClass.getUsername());
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
}