package com.todoApp.demoTodo.resource;

import com.todoApp.demoTodo.dto.Login;
import com.todoApp.demoTodo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginResource {

    @Autowired
    LoginService loginservice;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home(ModelMap modal) {
        modal.addAttribute("title","TodoEntity Example");
        return "index";
    }


    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/validate", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestBody Login login){
        boolean isValidUser = loginservice.validateUser(login.getUname(), login.getPassword());
        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        model.addAttribute("name", login.getUname());
        model.addAttribute("title","TodoEntity Example");
        return "index";
    }
}
