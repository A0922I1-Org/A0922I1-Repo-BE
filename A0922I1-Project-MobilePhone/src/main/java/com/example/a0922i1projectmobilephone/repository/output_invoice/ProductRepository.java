package com.example.a0922i1projectmobilephone.repository.output_invoice;//package com.example.a0922i1projectmobilephone.repository;
//
//import com.example.a0922i1projectmobilephone.dto.ProductResponseDTO;
//import com.example.a0922i1projectmobilephone.entity.Product;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//public interface ProductRepository extends JpaRepository<Product, Integer> {
//
//        @Query(value = "SELECT product_id, cost_product, quantity_product FROM product WHERE product_id = ?1", nativeQuery = true)
//        ProductResponseDTO findProductById(Integer productId);
//
//        @Modifying
//        @Transactional
//        @Query(value = "UPDATE product SET quantity_product = :quantity WHERE product_id = :productId", nativeQuery = true)
//        void updateProduct(@Param("productId") Integer productId, @Param("quantity") Integer quantity);
//
//}
