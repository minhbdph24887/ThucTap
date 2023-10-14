package com.example.thuctap.service.impl;

import com.example.thuctap.bean.*;
import com.example.thuctap.repository.*;
import com.example.thuctap.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService {
    private static final String CHAR_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUM = "0123456789";
    private static final String DATA_FOR_RANDOM_STRING = CHAR_UPPER + NUM;
    private static final Random random = new Random();
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ColorRepositoty colorRepositoty;

    @Autowired
    SizeRepository sizeRepository;

    @Autowired
    ProductItemsRepository productItemsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PromotionsRepository promotionsRepository;

    @Autowired
    PromotionsProductRepository promotionsProductRepository;

    // SERVICE ADMIN
    @Override
    public Page<User> getAllAdmin(Pageable pageable) {
        return userRepository.getAllUser(pageable);
    }

    @Override
    public User detailAdmin(Long idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Override
    public User addAdmin(User user) {
        User user1 = User.builder()
                .nameUser(user.getNameUser())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole())
                .sex(user.getSex())
                .birthday(user.getBirthday())
                .address(user.getAddress())
                .status(1)
                .username(user.getUsername())
                .passwordAdmin(user.getPasswordAdmin())
                .build();
        return userRepository.save(user1);
    }

    @Override
    public User updateAdmin(User user) {
        User user1 = userRepository.findById(user.getIdUser()).orElse(null).builder()
                .idUser(user.getIdUser())
                .nameUser(user.getNameUser())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole())
                .sex(user.getSex())
                .birthday(user.getBirthday())
                .address(user.getAddress())
                .status(user.getStatus())
                .username(user.getUsername())
                .passwordAdmin(user.getPasswordAdmin())
                .build();
        return userRepository.save(user1);
    }

    @Override
    public void deleteAdmin(Long idUser) {
        userRepository.deleteUser(idUser);
    }

    // SERVICE ROLE
    @Override
    public Page<Role> getAllRole(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role detailRole(Long idRole) {
        return roleRepository.findById(idRole).orElse(null);
    }

    @Override
    public Role addRole(Role role) {
        Role role1 = Role.builder()
                .nameRole(role.getNameRole())
                .status(1)
                .build();
        return roleRepository.save(role1);
    }

    @Override
    public Role updateRole(Role role) {
        Role role1 = roleRepository.findById(role.getIdRole()).orElse(null).builder()
                .idRole(role.getIdRole())
                .nameRole(role.getNameRole())
                .status(role.getStatus())
                .build();
        return roleRepository.save(role1);
    }

    @Override
    public void deleteRole(Long idRole) {
        roleRepository.deleteRole(idRole);
    }

    // SERVICE CLIENT
    @Override
    public Page<User> getAllClient(Pageable pageable) {
        return userRepository.getAllClient(pageable);
    }

    // SERVICE PRODUCT
    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> cbbProduct() {
        return productRepository.cbbProduct();
    }

    @Override
    public Product detailProduct(Long idProduct) {
        return productRepository.findById(idProduct).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        Product product1 = Product.builder()
                .nameProduct(product.getNameProduct())
                .category(product.getCategory())
                .description(product.getDescription())
                .status(1)
                .build();
        return productRepository.save(product1);
    }

    @Override
    public Product updateProduct(Product product) {
        Product product1 = productRepository.findById(product.getIdProduct()).orElse(null).builder()
                .idProduct(product.getIdProduct())
                .nameProduct(product.getNameProduct())
                .category(product.getCategory())
                .description(product.getDescription())
                .status(product.getStatus())
                .build();
        return productRepository.save(product1);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        productRepository.deleteProduct(idProduct);
    }

    // SERVICE MAU SAC
    @Override
    public Page<Color> getAllColor(Pageable pageable) {
        return colorRepositoty.findAll(pageable);
    }

    @Override
    public List<Color> cbbColor() {
        return colorRepositoty.cbbColor();
    }

    @Override
    public Color detailColor(Long idColor) {
        return colorRepositoty.findById(idColor).orElse(null);
    }

    @Override
    public Color addColor(Color color) {
        Color color1 = Color.builder()
                .nameColor("Màu" + " " + color.getNameColor())
                .status(1)
                .build();
        return colorRepositoty.save(color1);
    }

    @Override
    public Color updateColor(Color color) {
        Color color1 = colorRepositoty.findById(color.getIdColor()).orElse(null).builder()
                .idColor(color.getIdColor())
                .nameColor("Màu" + " " + color.getNameColor())
                .status(color.getStatus())
                .build();
        return colorRepositoty.save(color1);
    }

    @Override
    public void deleteColor(Long idColor) {
        colorRepositoty.deleteColor(idColor);
    }

    // SERVICE SIZE
    @Override
    public Page<Size> getAllSize(Pageable pageable) {
        return sizeRepository.findAll(pageable);
    }

    @Override
    public List<Size> cbbSize() {
        return sizeRepository.cbbSize();
    }

    @Override
    public Size detailSize(Long idSize) {
        return sizeRepository.findById(idSize).orElse(null);
    }

    @Override
    public Size addSize(Size size) {
        Size size1 = Size.builder()
                .nameSize("Size" + " " + size.getNameSize())
                .status(1)
                .build();
        return sizeRepository.save(size1);
    }

    @Override
    public Size updateSize(Size size) {
        Size size1 = sizeRepository.findById(size.getIdSize()).orElse(null).builder()
                .idSize(size.getIdSize())
                .nameSize("Size" + " " + size.getNameSize())
                .status(size.getStatus())
                .build();
        return sizeRepository.save(size1);
    }

    @Override
    public void deleteSize(Long idSize) {
        sizeRepository.deleteSize(idSize);
    }

    // SERVICE CHI TIET SAN PHAM
    @Override
    public Page<ProductItems> getAllProductItems(Pageable pageable) {
        return productItemsRepository.findAll(pageable);
    }

    @Override
    public List<ProductItems> cbbProductItems() {
        return productItemsRepository.cbbProductItems();
    }

    @Override
    public Page<ProductItems> getProductsByCategory(Pageable pageable, Long categoryId) {
        return productItemsRepository.findProductItemsByCategory(pageable, categoryId);
    }

    @Override
    public ProductItems detailProductItems(Long idProductItems) {
        return productItemsRepository.findById(idProductItems).orElse(null);
    }

    @Override
    public ProductItems addProductItems(ProductItems productItems) {
        ProductItems productItems1 = ProductItems.builder()
                .product(productItems.getProduct())
                .color(productItems.getColor())
                .size(productItems.getSize())
                .imagesProduct(productItems.getImagesProduct())
                .availableQuantity(productItems.getAvailableQuantity())
                .purchasePrice(productItems.getPurchasePrice())
                .costPrice(productItems.getCostPrice())
                .status(1)
                .build();
        return productItemsRepository.save(productItems1);
    }

    @Override
    public ProductItems updateProductItems(ProductItems productItems, MultipartFile file) throws IOException {
        // Lấy đường dẫn của ảnh cũ từ cơ sở dữ liệu
        String oldImagePath = productItemsRepository.findById(productItems.getIdProductItems()).get().getImagesProduct();
        // Kiểm tra xem file có rỗng hay không
        if (file.isEmpty()) {
            // Nếu rỗng, sử dụng đường dẫn của ảnh cũ
            productItems.setImagesProduct(oldImagePath);
        } else {
            // Nếu không rỗng, lấy đường dẫn của ảnh mới và lưu vào thư mục images
            String fileName = file.getOriginalFilename();
            String imagePath = "images/" + fileName;
            file.transferTo(new File(imagePath));
            // Sử dụng đường dẫn của ảnh mới
            productItems.setImagesProduct(imagePath);
        }
        // Cập nhật lại thông tin sản phẩm vào cơ sở dữ liệu
        ProductItems updatedProductItems = productItemsRepository.findById(productItems.getIdProductItems()).orElse(null).builder()
                .idProductItems(productItems.getIdProductItems())
                .product(productItems.getProduct())
                .color(productItems.getColor())
                .size(productItems.getSize())
                .imagesProduct(productItems.getImagesProduct()) // Đường dẫn hình ảnh đã được cập nhật
                .availableQuantity(productItems.getAvailableQuantity())
                .purchasePrice(productItems.getPurchasePrice())
                .costPrice(productItems.getCostPrice())
                .status(productItems.getStatus())
                .build();
        return productItemsRepository.save(updatedProductItems);
    }

    @Override
    public void deleteProductItems(Long idProductItems) {
        productItemsRepository.deleteProductItems(idProductItems);
    }

    // SERVICE DANH MUC
    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> viewCategory() {
        return categoryRepository.viewClientCategory();
    }

    @Override
    public Category detailCategory(Long idCategory) {
        return categoryRepository.findById(idCategory).orElse(null);
    }

    @Override
    public Category addCategory(Category category) {
        Category category1 = Category.builder()
                .nameCategory(category.getNameCategory())
                .status(1)
                .build();
        return categoryRepository.save(category1);
    }

    @Override
    public Category updateCategory(Category category) {
        Category category1 = categoryRepository.findById(category.getIdCategory()).orElse(null).builder()
                .idCategory(category.getIdCategory())
                .nameCategory(category.getNameCategory())
                .status(category.getStatus())
                .build();
        return categoryRepository.save(category1);
    }

    @Override
    public void deleteCategory(Long idCategory) {
        categoryRepository.deleteCategory(idCategory);
    }

    // SERVICE VOURCHER
    @Override
    public Page<Promotions> getAllPromotions(Pageable pageable) {
        Page<Promotions> promotions = promotionsRepository.findAll(pageable);
        for (Promotions promotion : promotions) {
            promotion.updateStatusPromotions();
            promotionsRepository.save(promotion); // Lưu lại trạng thái đã cập nhật
        }
        return promotions;
    }


    @Override
    public Promotions detailPromotions(Long idPromotions) {
        return promotionsRepository.findById(idPromotions).orElse(null);
    }

    // Khởi tạo chuỗi kí tự cả chữ cái in hoa và số
    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

    @Override
    public Promotions addPromotions(Promotions promotions) {
        Promotions promotions1 = Promotions.builder()
                .codePromotions(generateRandomString())
                .namePromotions(promotions.getNamePromotions())
                .person(promotions.getPerson())
                .quantity(promotions.getQuantity())
                .startDate(promotions.getStartDate())
                .endDate(promotions.getEndDate())
                .description(promotions.getDescription())
                .status(1)
                .build();
        return promotionsRepository.save(promotions1);
    }

    @Override
    public Promotions updatePromotions(Promotions promotions) {
        Promotions promotions1 = Promotions.builder()
                .idPromotions(promotions.getIdPromotions())
                .codePromotions(generateRandomString())
                .namePromotions(promotions.getNamePromotions())
                .person(promotions.getPerson())
                .quantity(promotions.getQuantity())
                .startDate(promotions.getStartDate())
                .endDate(promotions.getEndDate())
                .description(promotions.getDescription())
                .status(promotions.getStatus())
                .build();
        return promotionsRepository.save(promotions1);
    }

    // SERVICE VOURCHER DETAIL
    @Override
    public Page<PromotionsProduct> getAllPromotionsProducts(Pageable pageable, Long idPromotions) {
        return promotionsProductRepository.getAllPromotionsProduct(pageable, idPromotions);
    }

    @Override
    public PromotionsProduct addPromotionsProduct(PromotionsProduct promotionsProduct) {
        PromotionsProduct promotionsProduct1 = PromotionsProduct.builder()
                .promotions(promotionsProduct.getPromotions())
                .productItems(promotionsProduct.getProductItems())
                .status(1)
                .build();
        return promotionsProductRepository.save(promotionsProduct1);
    }

    @Override
    public PromotionsProduct deletePromotionsProduct(Long idPromotionsProduct) {
        Optional<PromotionsProduct> removePromotionsProduct = promotionsProductRepository.findById(idPromotionsProduct);
        if (removePromotionsProduct.isPresent()) {
            promotionsProductRepository.deleteById(idPromotionsProduct);
            return removePromotionsProduct.get();
        }
        return null;
    }

}
