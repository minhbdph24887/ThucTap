package com.example.thuctap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getAllCart(){
        return "viewer/cart";
    }
}
