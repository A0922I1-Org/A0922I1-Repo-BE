package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    //findProductById
    @Query(value = "select * from product where product_id = ?1", nativeQuery = true)
    Product findProductById(Integer id);

    String sql_create = "INSERT INTO products (product_name, selling_price, screen_size, font_camera, back_camera, product_cpu, image_url, product_storage, description, category_id, brand_id) " +
            "values(?1 ,?2 ,?3 ,?4 ,?5 ,?6 ,?7 ,?8 ,?9 ,?10, ?11)";
    @Modifying
    @Query(value = sql_create, nativeQuery = true)
    void createProduct(String productName, Integer sellingPrice, String screenSize, String fontCamera, String backCamera, String productCpu, String imageUrl, String productStorage, String description, Integer categoryId, Integer brandId);

    String sql_edit="UPDATE FROM Product " +
            "SET product_name = ?1, selling_price=?2, screen_size=?3, front_camera=?4, back_camera=?5, product_cpu=?6, image_url=?7, product_storage=?8, decription=?9, category_id=?10, brand_id=?11"
            +"WHERE product_id = ?12";
    @Modifying
    @Query(value = sql_edit, nativeQuery = true)
    void editProduct(String productName, Integer sellingPrice, String screenSize, String fontCamera, String backCamera, String productCpu, String imageUrl, String productStorage, String description, Integer categoryId, Integer brandId, Integer productId);;

}
