package com.example.thuctap.service;

import com.example.thuctap.bean.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminService {
    // VIEW ADMIN
    Page<User> getAllAdmin(Pageable pageable);

    User detailAdmin(Long idUser);

    User addAdmin(User user);

    User updateAdmin(User user);

    void deleteAdmin(Long idUser);

    // VIEW QUYEN
    Page<Role> getAllRole(Pageable pageable);

    Role detailRole(Long idRole);

    Role addRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Long idRole);

    // VIEW CLIENT
    Page<User> getAllClient(Pageable pageable);

    // VIEW SAN PHAM
    Page<Product> getAllProduct(Pageable pageable);

    List<Product> cbbProduct();

    Product detailProduct(Long idProduct);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long idProduct);

    // VIEW MAU SAC
    Page<Color> getAllColor(Pageable pageable);

    List<Color> cbbColor();

    Color detailColor(Long idColor);

    Color addColor(Color color);

    Color updateColor(Color color);

    void deleteColor(Long idColor);

    // VIEW SIZE
    Page<Size> getAllSize(Pageable pageable);

    List<Size> cbbSize();

    Size detailSize(Long idSize);

    Size addSize(Size size);

    Size updateSize(Size size);

    void deleteSize(Long idSize);

    // VIEW CHI TIET SAN PHAM
    Page<ProductItems> getAllProductItems(Pageable pageable);

    List<ProductItems> cbbProductItems();

    ProductItems detailProductItems(Long idProductItems);

    ProductItems addProductItems(ProductItems productItems);

    ProductItems updateProductItems(ProductItems productItems);

    void deleteProductItems(Long idProductItems);

    // VIEW CATEGORY
    Page<Category> getAllCategory(Pageable pageable);

    List<Category> viewCategory();

    Category detailCategory(Long idCategory);

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long idCategory);

    // VIEW VOURCHER
    Page<Promotions> getAllPromotions(Pageable pageable);

    Promotions detailPromotions(Long idPromotions);

    Promotions addPromotions(Promotions promotions);

    Promotions updatePromotions(Promotions promotions);

    // VIEW VOURCHER DETAIL
    Page<PromotionsProduct> getAllPromotionsProducts(Pageable pageable, Long idPromotions);

    PromotionsProduct addPromotionsProduct(PromotionsProduct promotionsProduct);

    PromotionsProduct deletePromotionsProduct(Long idPromotionsProduct);
}
