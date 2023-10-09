package com.example.thuctap.controller;

import com.example.thuctap.bean.User;
import com.example.thuctap.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    List<User> listUser = new ArrayList<>();
    @Autowired
    AdminService adminService;


    // VIEW CUA ADMIN
    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
    public String viewAdmin(Model model) {
        return "admin/viewadmindetail";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String viewUser(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<User> itemUser = adminService.getAllAdmin(PageRequest.of(page, 5));
        model.addAttribute("listAdmin", itemUser);
        model.addAttribute("currentPage", page);
        return "admin/user/viewadmin";
    }

    @RequestMapping(value = "/admin/user/view-add", method = RequestMethod.GET)
    public String viewAddAdmin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/user/view-add";
    }

    @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
    public String addUser(User user) {
        adminService.addAdmin(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/detail/{idUser}", method = RequestMethod.GET)
    public String detailAdmin(Model model, @PathVariable("idUser") Long idUser){
        User detailUser = adminService.detailAdmin(idUser);
        model.addAttribute("detailAdmin", detailUser);
        return "admin/user/view-update";
    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String updateAdmin(User user){
        adminService.updateAdmin(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/delete/{idUser}", method = RequestMethod.POST)
    public String deleteAdmin(@PathVariable("idUser") Long idUser){
        adminService.deleteAdmin(idUser);
        return "redirect:/admin/user";
    }

    // VIEW CUA KHACH HANG

    // VIEW CUA SAN PHAM

    // VIEW CUA THONG KE
}
