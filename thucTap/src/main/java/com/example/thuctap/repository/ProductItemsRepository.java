package com.example.thuctap.repository;

import com.example.thuctap.bean.Product;
import com.example.thuctap.bean.ProductItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductItemsRepository extends JpaRepository<ProductItems, Long> {
    @Query(value = "select * from ProductItems where Status= 1", nativeQuery = true)
    List<ProductItems> cbbProductItems();

    @Modifying
    @Transactional
    @Query(value = "update ProductItems set Status= 0 where ID= :idProductItems", nativeQuery = true)
    void deleteProductItems(@Param("idProductItems") Long idProductItems);
}
