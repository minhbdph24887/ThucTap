package com.example.thuctap.controller;

import com.example.thuctap.bean.*;
import com.example.thuctap.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("idPromotions")
public class AdminController {
    List<Category> listCategory = new ArrayList<>();
    List<Product> listProduct = new ArrayList<>();
    List<Color> listColor = new ArrayList<>();
    List<Size> listSize = new ArrayList<>();
    List<ProductItems> listProductItems = new ArrayList<>();
    @Autowired
    AdminService adminService;

    // CONTROLLER ADMIN
    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
    public String viewAdmin(Model model) {
        return "admin/viewadmindetail";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String viewUser(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<User> itemUser = adminService.getAllAdmin(PageRequest.of(page, 5));
        model.addAttribute("listAdmin", itemUser);
        model.addAttribute("currentPage", page);
        return "admin/user/adminer/viewadmin";
    }

    @RequestMapping(value = "/admin/user/view-add", method = RequestMethod.GET)
    public String viewAddAdmin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/user/adminer/view-add";
    }

    @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
    public String addUser(User user) {
        adminService.addAdmin(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/detail/{idUser}", method = RequestMethod.GET)
    public String detailAdmin(Model model, @PathVariable("idUser") Long idUser) {
        User detailUser = adminService.detailAdmin(idUser);
        model.addAttribute("detailAdmin", detailUser);
        return "admin/user/adminer/view-update";
    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String updateAdmin(User user) {
        adminService.updateAdmin(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/delete/{idUser}", method = RequestMethod.GET)
    public String deleteAdmin(@PathVariable("idUser") Long idUser) {
        adminService.deleteAdmin(idUser);
        return "redirect:/admin/user";
    }

    // CONTROLLER KHACH HANG
    @RequestMapping(value = "/admin/client", method = RequestMethod.GET)
    public String viewClient(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<User> itemUser = adminService.getAllClient(PageRequest.of(page, 5));
        model.addAttribute("listClient", itemUser);
        model.addAttribute("currentPage", page);
        return "admin/user/client/viewclient";
    }

    @RequestMapping(value = "/admin/client/view-add", method = RequestMethod.GET)
    public String viewAddClient(Model model) {
        User user = new User();
        model.addAttribute("client", user);
        return "admin/user/client/view-add";
    }

    @RequestMapping(value = "/admin/client/add", method = RequestMethod.POST)
    public String addClient(User user) {
        adminService.addAdmin(user);
        return "redirect:/admin/client";
    }

    @RequestMapping(value = "/admin/client/detail/{idUser}", method = RequestMethod.GET)
    public String detailClient(Model model, @PathVariable("idUser") Long idUser) {
        User detailUser = adminService.detailAdmin(idUser);
        model.addAttribute("detailClient", detailUser);
        return "admin/user/client/view-update";
    }

    @RequestMapping(value = "/admin/client/update", method = RequestMethod.POST)
    public String updateClient(User user) {
        adminService.updateAdmin(user);
        return "redirect:/admin/client";
    }

    @RequestMapping(value = "/admin/client/delete/{idUser}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable("idUser") Long idUser) {
        adminService.deleteAdmin(idUser);
        return "redirect:/admin/client";
    }

    // CONTROLLER QUYEN
    @RequestMapping(value = "/admin/role", method = RequestMethod.GET)
    public String viewRole(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Role> itemRole = adminService.getAllRole(PageRequest.of(page, 5));
        model.addAttribute("listRole", itemRole);
        model.addAttribute("currentPage", page);
        return "admin/user/role/viewrole";
    }

    @RequestMapping(value = "/admin/role/view-add", method = RequestMethod.GET)
    public String viewAddRole(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "admin/user/role/view-add";
    }

    @RequestMapping(value = "/admin/role/add", method = RequestMethod.POST)
    public String addRole(Role role) {
        adminService.addRole(role);
        return "redirect:/admin/role";
    }

    @RequestMapping(value = "/admin/role/detail/{idRole}", method = RequestMethod.GET)
    public String detailRole(Model model, @PathVariable("idRole") Long idRole) {
        Role detailRole = adminService.detailRole(idRole);
        model.addAttribute("detailRole", detailRole);
        return "admin/user/role/view-update";
    }

    @RequestMapping(value = "/admin/role/update", method = RequestMethod.POST)
    public String updateRole(Role role) {
        adminService.updateRole(role);
        return "redirect:/admin/role";
    }

    @RequestMapping(value = "/admin/role/delete/{idRole}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable("idRole") Long idRole) {
        adminService.deleteRole(idRole);
        return "redirect:/admin/role";
    }

    // CONTROLLER SAN PHAM
    @RequestMapping(value = "/admin/product", method = RequestMethod.GET)
    public String viewProduct(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> itemProduct = adminService.getAllProduct(PageRequest.of(page, 5));
        model.addAttribute("listProduct", itemProduct);
        model.addAttribute("currentPage", page);
        return "admin/detail/product/viewproduct";
    }

    @RequestMapping(value = "/admin/product/view-add", method = RequestMethod.GET)
    public String viewAddProduct(Model model) {
        Product product = new Product();
        listCategory = adminService.viewCategory();
        model.addAttribute("product", product);
        model.addAttribute("listCategory", listCategory);
        return "admin/detail/product/view-add";
    }

    @RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
    public String addProduct(Product product) {
        adminService.addProduct(product);
        return "redirect:/admin/product";
    }

    @RequestMapping(value = "/admin/product/detail/{idProduct}", method = RequestMethod.GET)
    public String detailProduct(Model model, @PathVariable("idProduct") Long idProduct) {
        Product detailProduct = adminService.detailProduct(idProduct);
        listCategory = adminService.viewCategory();
        model.addAttribute("detailProduct", detailProduct);
        model.addAttribute("listCategory", listCategory);
        return "admin/detail/product/view-update";
    }

    @RequestMapping(value = "/admin/product/update", method = RequestMethod.POST)
    public String updateProduct(Product product) {
        adminService.updateProduct(product);
        return "redirect:/admin/product";
    }

    @RequestMapping(value = "/admin/product/delete/{idProduct}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("idProduct") Long idProduct) {
        adminService.deleteProduct(idProduct);
        return "redirect:/admin/product";
    }

    // CONTROLLER MAU SAC
    @RequestMapping(value = "/admin/color", method = RequestMethod.GET)
    public String viewColor(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Color> itemColor = adminService.getAllColor(PageRequest.of(page, 5));
        model.addAttribute("listColor", itemColor);
        model.addAttribute("currentPage", page);
        return "admin/detail/color/viewcolor";
    }

    @RequestMapping(value = "/admin/color/view-add", method = RequestMethod.GET)
    public String viewAddColor(Model model) {
        Color color = new Color();
        model.addAttribute("color", color);
        return "admin/detail/color/view-add";
    }

    @RequestMapping(value = "/admin/color/add", method = RequestMethod.POST)
    public String addColor(Color color) {
        adminService.addColor(color);
        return "redirect:/admin/color";
    }

    @RequestMapping(value = "/admin/color/detail/{idColor}", method = RequestMethod.GET)
    public String detailColor(Model model, @PathVariable("idColor") Long idColor) {
        Color detailColor = adminService.detailColor(idColor);
        model.addAttribute("detailColor", detailColor);
        return "admin/detail/color/view-update";
    }

    @RequestMapping(value = "/admin/color/update", method = RequestMethod.POST)
    public String updateColor(Color color) {
        adminService.updateColor(color);
        return "redirect:/admin/color";
    }

    @RequestMapping(value = "/admin/color/delete/{idColor}", method = RequestMethod.GET)
    public String deleteColor(@PathVariable("idColor") Long idColor) {
        adminService.deleteColor(idColor);
        return "redirect:/admin/color";
    }

    // CONTROLLER SIZE
    @RequestMapping(value = "/admin/size", method = RequestMethod.GET)
    public String viewSize(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Size> itemSize = adminService.getAllSize(PageRequest.of(page, 5));
        model.addAttribute("listSize", itemSize);
        model.addAttribute("currentPage", page);
        return "admin/detail/size/viewsize";
    }

    @RequestMapping(value = "/admin/size/view-add", method = RequestMethod.GET)
    public String viewAddSize(Model model) {
        Size size = new Size();
        model.addAttribute("size", size);
        return "admin/detail/size/view-add";
    }

    @RequestMapping(value = "/admin/size/add", method = RequestMethod.POST)
    public String addSize(Size size) {
        adminService.addSize(size);
        return "redirect:/admin/size";
    }

    @RequestMapping(value = "/admin/size/detail/{idSize}", method = RequestMethod.GET)
    public String detailSize(Model model, @PathVariable("idSize") Long idSize) {
        Size detailSize = adminService.detailSize(idSize);
        model.addAttribute("detailSize", detailSize);
        return "admin/detail/size/view-update";
    }

    @RequestMapping(value = "/admin/size/update", method = RequestMethod.POST)
    public String updateSize(Size size) {
        adminService.updateSize(size);
        return "redirect:/admin/size";
    }

    @RequestMapping(value = "/admin/size/delete/{idSize}", method = RequestMethod.GET)
    public String deleteSize(@PathVariable("idSize") Long idSize) {
        adminService.deleteSize(idSize);
        return "redirect:/admin/size";
    }

    // CONTROLLER CHI TIET SAN PHAM
    @RequestMapping(value = "/admin/productitems", method = RequestMethod.GET)
    public String viewProductItems(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<ProductItems> itemProductItems = adminService.getAllProductItems(PageRequest.of(page, 5));
        model.addAttribute("listProductItems", itemProductItems);
        model.addAttribute("currentPage", page);
        return "admin/detail/productItems/viewproductitems";
    }

    @RequestMapping(value = "/admin/productitems/view-add", method = RequestMethod.GET)
    public String viewAddProductItems(Model model) {
        ProductItems productItems = new ProductItems();
        listProduct = adminService.cbbProduct();
        listColor = adminService.cbbColor();
        listSize = adminService.cbbSize();
        model.addAttribute("productItems", productItems);
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listColor", listColor);
        model.addAttribute("listSize", listSize);
        return "admin/detail/productItems/view-add";
    }

    @RequestMapping(value = "/admin/productitems/add", method = RequestMethod.POST)
    public String addProductItems(ProductItems productItems) {
        adminService.addProductItems(productItems);
        return "redirect:/admin/productitems";
    }

    @RequestMapping(value = "/admin/productitems/detail/{idProductItems}", method = RequestMethod.GET)
    public String detailProductItems(Model model, @PathVariable("idProductItems") Long idProductItems) {
        ProductItems detailProductItems = adminService.detailProductItems(idProductItems);
        listProduct = adminService.cbbProduct();
        listColor = adminService.cbbColor();
        listSize = adminService.cbbSize();
        model.addAttribute("detailProductItems", detailProductItems);
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listColor", listColor);
        model.addAttribute("listSize", listSize);
        return "admin/detail/productItems/view-update";
    }

    @RequestMapping(value = "/admin/productitems/update", method = RequestMethod.POST)
    public String updateProductItems(ProductItems productItems) {
        adminService.updateProductItems(productItems);
        return "redirect:/admin/productitems";
    }

    @RequestMapping(value = "/admin/productitems/delete/{idProductItems}", method = RequestMethod.GET)
    public String deleteProductItems(@PathVariable("idProductItems") Long idProductItems) {
        adminService.deleteProductItems(idProductItems);
        return "redirect:/admin/productitems";
    }

    // CONTROLLER DANH MUC
    @RequestMapping(value = "/admin/category", method = RequestMethod.GET)
    public String viewCategory(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Category> itemCategory = adminService.getAllCategory(PageRequest.of(page, 5));
        model.addAttribute("listCategory", itemCategory);
        model.addAttribute("currentPage", page);
        return "admin/detail/category/viewcategory";
    }

    @RequestMapping(value = "/admin/category/view-add", method = RequestMethod.GET)
    public String viewAddCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/detail/category/view-add";
    }

    @RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
    public String addCategory(Category category) {
        adminService.addCategory(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/detail/{idCategory}", method = RequestMethod.GET)
    public String detailCategory(Model model, @PathVariable("idCategory") Long idCategory) {
        Category detailCategory = adminService.detailCategory(idCategory);
        model.addAttribute("detailCategory", detailCategory);
        return "admin/detail/category/view-update";
    }

    @RequestMapping(value = "/admin/category/update", method = RequestMethod.POST)
    public String updateCategory(Category category) {
        adminService.updateCategory(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/delete/{idCategory}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("idCategory") Long idCategory) {
        adminService.deleteCategory(idCategory);
        return "redirect:/admin/category";
    }

    // CONTROLLER VOURCHER
    @RequestMapping(value = "/admin/voucher", method = RequestMethod.GET)
    public String getAllVoucher(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Promotions> itemsPromotions = adminService.getAllPromotions(PageRequest.of(page, 5));
        model.addAttribute("listPromotions", itemsPromotions);
        model.addAttribute("currentPage", page);
        return "admin/voucher/promotions/viewPromotions";
    }


    @RequestMapping(value = "/admin/voucher/view-add", method = RequestMethod.GET)
    public String viewAddVoucher(Model model) {
        Promotions promotions = new Promotions();
        listProductItems = adminService.cbbProductItems();
        model.addAttribute("promotions", promotions);
        model.addAttribute("listProductItems", listProductItems);
        return "admin/voucher/promotions/view-add";
    }

    @RequestMapping(value = "/admin/voucher/add", method = RequestMethod.POST)
    public String addVoucher(Promotions promotions) {
        adminService.addPromotions(promotions);
        return "redirect:/admin/voucher";
    }

    @RequestMapping(value = "/admin/voucher/detail/{idPromotions}", method = RequestMethod.GET)
    public String detailPromotionsProduct(Model model, @PathVariable("idPromotions") Long idPromotions, @RequestParam(defaultValue = "0") int page) {
        Promotions promotions = adminService.detailPromotions(idPromotions);
        Page<PromotionsProduct> itemsPromotionsProducts = adminService.getAllPromotionsProducts(PageRequest.of(page, 5), promotions.getIdPromotions());
        model.addAttribute("detailPromotions", promotions);
        model.addAttribute("listPromotionsProducts", itemsPromotionsProducts);
        model.addAttribute("currentPage", page);
        model.addAttribute("idPromotions", idPromotions);
        return "admin/voucher/promotionsProduct/viewPromotionsProduct";
    }

    @RequestMapping(value = "/admin/voucher/update", method = RequestMethod.POST)
    public String updatePromotionsProduct(Promotions promotions) {
        adminService.updatePromotions(promotions);
        return "redirect:/admin/voucher";
    }

    @RequestMapping(value = "/admin/voucherdetail/view-add", method = RequestMethod.GET)
    public String addProductVoucher(Model model, @ModelAttribute("idPromotions") Long idPromotions) {
        PromotionsProduct promotionsProduct = new PromotionsProduct();
        Promotions promotions = adminService.detailPromotions(idPromotions);
        listProductItems = adminService.cbbProductItems();
        model.addAttribute("detailPromotions", promotions);
        model.addAttribute("promotionsProduct", promotionsProduct);
        model.addAttribute("listProductItems", listProductItems);
        return "admin/voucher/promotionsProduct/view-add";
    }

    @RequestMapping(value = "/admin/voucherdetail/add", method = RequestMethod.POST)
    public String addPromotionsProduct(PromotionsProduct promotionsProduct, RedirectAttributes redirectAttributes) {
        adminService.addPromotionsProduct(promotionsProduct);
        redirectAttributes.addAttribute("idPromotions", promotionsProduct.getPromotions().getIdPromotions());
        return "redirect:/admin/voucher/detail/{idPromotions}";
    }

    @RequestMapping(value = "/admin/voucherdetail/remove/{idPromotionsProduct}", method = RequestMethod.GET)
    public String deletePromotionsProduct(PromotionsProduct promotionsProduct, @PathVariable("idPromotionsProduct") Long idPromotionsProduct, RedirectAttributes redirectAttributes) {
        PromotionsProduct removedPromotionProduct = adminService.deletePromotionsProduct(idPromotionsProduct);
        if (removedPromotionProduct != null && removedPromotionProduct.getPromotions() != null && removedPromotionProduct.getPromotions().getIdPromotions() != null) {
            redirectAttributes.addAttribute("idPromotions", removedPromotionProduct.getPromotions().getIdPromotions());
        }
        return "redirect:/admin/voucher/detail/{idPromotions}";
    }


    // VIEW CUA THONG KE
}
