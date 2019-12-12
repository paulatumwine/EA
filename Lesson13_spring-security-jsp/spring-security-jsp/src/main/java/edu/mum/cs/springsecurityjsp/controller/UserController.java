package edu.mum.cs.springsecurityjsp.controller;

import edu.mum.cs.springsecurityjsp.model.User;
import edu.mum.cs.springsecurityjsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/index")
    public String userIndex(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getCredentials());
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        return "user/index";
    }

    @GetMapping("/admin/index")
    public String adminIndex(Model model) {
        return "user/admin";
    }

    @GetMapping("/dba/index")
    public String dbaIndex(Model model) {
        return "user/dba";
    }
}
