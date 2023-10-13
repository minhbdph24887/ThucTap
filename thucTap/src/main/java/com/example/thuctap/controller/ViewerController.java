package com.example.thuctap.controller;

import com.example.thuctap.bean.Category;
import com.example.thuctap.bean.ProductItems;
import com.example.thuctap.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewerController {
    List<Category> listCategory = new ArrayList<>();
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String viewAllViewer(Model model, @RequestParam(defaultValue = "0") int page){
        listCategory = adminService.viewCategory();
        Page<ProductItems> listProductItems = adminService.getAllProductItems(PageRequest.of(page, 6));
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("listProduct", listProductItems);
        return "viewer/indexviewer";
    }
}
