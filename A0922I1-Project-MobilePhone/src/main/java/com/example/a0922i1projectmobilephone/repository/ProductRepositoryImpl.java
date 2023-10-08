//package com.example.a0922i1projectmobilephone.repository;
//
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//@Repository
//public class ProductRepositoryImpl {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public ProductDTO findProductById(Integer productId) {
//        String sql = "SELECT product_id, name_product, cost_product FROM product WHERE product_id = :productId";
//        Query query = entityManager.createNativeQuery(sql);
//        query.setParameter("productId", productId);
//
//        List<Object[]> results = query.getResultList();
//
//        if (!results.isEmpty()) {
//            Object[] result = results.get(0);
//
//            Integer productIdValue = (Integer) result[0];
//            String nameProductValue = (String) result[1];
//            Integer costProductValue = (Integer) result[2];
//
//            return new ProductDTO(productIdValue, nameProductValue, costProductValue);
//        }
//
//        return null;
//    }
//}
