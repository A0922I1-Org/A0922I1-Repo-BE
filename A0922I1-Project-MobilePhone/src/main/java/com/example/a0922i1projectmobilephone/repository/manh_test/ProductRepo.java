package com.example.a0922i1projectmobilephone.repository.manh_test;

import com.example.a0922i1projectmobilephone.dto.input_invoice.ProductInputDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductRepo {
    @PersistenceContext
    EntityManager em;

public int addNewProduct(ProductInputDto product){
    boolean isDone = false;
 if (em.createNativeQuery("insert into mobilephone.product(back_camera_product, cost_product, " +
                 "description_product, front_camera_product, image_url_product, product_cpu_product, " +
                 "name_product, product_storage_product, quantity_product, screen_size_product, " +
                 "selling_price_product, brand_id, category_id)" +
         "values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13)")
         .setParameter(1, "Yeu cau cap nhat")
         .setParameter(2, product.getCostPrice())
         .setParameter(3, "Yeu cau cap nhat")
         .setParameter(4, "Yeu cau cap nhat")
         .setParameter(5, "Yeu cau cap nhat")
         .setParameter(6, "Yeu cau cap nhat")
         .setParameter(7, product.getProductName())
         .setParameter(8, "Yeu cau cap nhat")
         .setParameter(9, product.getQuantity())
         .setParameter(10, "Yeu cau cap nhat")
         .setParameter(11, null)
         .setParameter(12, null)
         .setParameter(13, null).executeUpdate() >0){
     isDone =true;
 }
 if (isDone){
     return getLastInsert();
 }
 return 0;
}

    int getLastInsert() {
        return (int) em.createNativeQuery("SELECT MAX(product_id) from product").getSingleResult();
    }

   public int adjustQuantityAndCost(ProductInputDto dto){
        return em.createNativeQuery("update product" +
        " set cost_product = (cost_product * quantity_product + ?1 )/(quantity_product + ?2), " +
                "quantity_product = quantity_product + ?2 " +
                        "where product_id = ?3")
                .setParameter(1, dto.getCostPrice())
                .setParameter(2, dto.getQuantity())
                .setParameter(3, dto.getProductId())
                .executeUpdate();
    }
}