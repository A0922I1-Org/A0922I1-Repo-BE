package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT p.* FROM Product p JOIN Brand b ON p.brand_id = b.brand_id ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p JOIN Brand b ON p.brand_id = b.brand_id ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> findAllProducts(Pageable pageable);

    @Query(value = "SELECT p.* FROM Product p where p.product_id =:productId",
            nativeQuery = true)
    Product findProductById(@Param("productId") Integer productId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Product p where p.product_id =:productId",
            nativeQuery = true)
    void deleteProductById(@Param("productId") Integer productId);

    @Query(value = "SELECT p.* FROM Product p JOIN Brand b ON p.brand_id = b.brand_id " +
            "WHERE b.brand_name = :brandName " +
            "AND p.selling_price_product >= :minPrice " +
            "AND p.selling_price_product <= :maxPrice " +
            "AND p.name_product LIKE CONCAT('%', :productName, '%') " +
            "ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p " +
                    "JOIN Brand b ON p.brand_id = b.brand_id " +
                    "WHERE b.brand_name = :brandName " +
                    "AND p.selling_price_product >= :minPrice " +
                    "AND p.selling_price_product <= :maxPrice " +
                    "AND p.name_product LIKE CONCAT('%', :productName, '%') " +
                    "ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> searchProducts(@Param("brandName") String brandName,
                                 @Param("minPrice") Double minPrice,
                                 @Param("maxPrice") Double maxPrice,
                                 @Param("productName") String productName,
                                 Pageable pageable);

    @Query(value = "SELECT p.* FROM Product p JOIN Brand b ON p.brand_id = b.brand_id " +
            "WHERE b.brand_name = :brandName " +
            "AND p.name_product LIKE CONCAT('%', :productName, '%') " +
            "ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p " +
                    "JOIN Brand b ON p.brand_id = b.brand_id " +
                    "WHERE b.brand_name = :brandName " +
                    "AND p.name_product LIKE CONCAT('%', :productName, '%') " +
                    "ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> searchProducts(@Param("brandName") String brandName,
                                 @Param("productName") String productName,
                                 Pageable pageable);

    @Query(value = "SELECT p.* FROM Product p " +
            "WHERE p.name_product LIKE CONCAT('%', :productName, '%') " +
            "ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p " +
                    "WHERE p.name_product LIKE CONCAT('%', :productName, '%') " +
                    "ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> searchProductsByName(@Param("productName") String productName,
                                 Pageable pageable);

    @Query(value = "SELECT p.* FROM Product p JOIN Brand b ON p.brand_id = b.brand_id " +
            "WHERE b.brand_name = :brandName " +
            "ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p " +
                    "JOIN Brand b ON p.brand_id = b.brand_id " +
                    "WHERE b.brand_name = :brandName " +
                    "ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> searchProductsByBrand(@Param("brandName") String brandName,
                                 Pageable pageable);

    @Query(value = "SELECT p.* FROM Product p " +
            "WHERE p.selling_price_product >= :minPrice " +
            "AND p.selling_price_product <= :maxPrice " +
            "AND p.name_product LIKE CONCAT('%', :productName, '%') " +
            "ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p " +
                    "WHERE p.selling_price_product >= :minPrice " +
                    "AND p.selling_price_product <= :maxPrice " +
                    "AND p.name_product LIKE CONCAT('%', :productName, '%') " +
                    "ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> searchProducts(@Param("minPrice") Double minPrice,
                                 @Param("maxPrice") Double maxPrice,
                                 @Param("productName") String productName,
                                 Pageable pageable);

    @Query(value = "SELECT p.* FROM Product p " +
            "WHERE p.selling_price_product >= :minPrice " +
            "AND p.selling_price_product <= :maxPrice " +
            "ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p " +
                    "WHERE p.selling_price_product >= :minPrice " +
                    "AND p.selling_price_product <= :maxPrice " +
                    "ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> searchProducts(@Param("minPrice") Double minPrice,
                                 @Param("maxPrice") Double maxPrice,
                                 Pageable pageable);

    @Query(value = "SELECT p.* FROM Product p JOIN Brand b ON p.brand_id = b.brand_id " +
            "WHERE b.brand_name = :brandName " +
            "AND p.selling_price_product >= :minPrice " +
            "AND p.selling_price_product <= :maxPrice " +
            "ORDER BY p.product_id ASC",
            countQuery = "SELECT p.* FROM Product p " +
                    "JOIN Brand b ON p.brand_id = b.brand_id " +
                    "WHERE b.brand_name = :brandName " +
                    "AND p.selling_price_product >= :minPrice " +
                    "AND p.selling_price_product <= :maxPrice " +
                    "ORDER BY p.product_id ASC",
            nativeQuery = true)
    Page<Product> searchProducts(@Param("brandName") String brandName,
                                 @Param("minPrice") Double minPrice,
                                 @Param("maxPrice") Double maxPrice,
                                 Pageable pageable);
}
