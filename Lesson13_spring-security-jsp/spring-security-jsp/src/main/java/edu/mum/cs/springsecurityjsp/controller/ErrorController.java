package edu.mum.cs.springsecurityjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {
    @GetMapping(value = "/access-denied")
    public String accessDenied() {
        return "403";
    }
}
