package com.example.thuctap.restcontroller;

import com.example.thuctap.bean.ProductItems;
import com.example.thuctap.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class AddToCart {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/product/{idProductItems}", method = RequestMethod.GET)
    public ProductItems getOneCart(@PathVariable("idProductItems") Long idProductItems){
        return adminService.detailProductItems(idProductItems);
    }
}
