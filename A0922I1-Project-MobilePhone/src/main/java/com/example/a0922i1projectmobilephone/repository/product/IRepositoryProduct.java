package com.example.a0922i1projectmobilephone.repository.product;
import com.example.a0922i1projectmobilephone.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IRepositoryProduct extends JpaRepository<Product, Integer> {
    @Query(value = "select *  " +
            " from product " +
            "WHERE\n" +
            "    (\n" +
            "        (:option = 'name' AND name_product LIKE %:search%) OR\n" +
            "        (:option = 'price' AND cost_product  = :search) OR\n" +
            "        (:option = 'cpu' AND product_cpu LIKE %:search%)\n" +
            "    )\n" +
            "    OR :isAll = 1" +
            "    OR product_storage LIKE %:storage%\n", nativeQuery = true)
    Page<Product> listProduct(Pageable pageable,
                              @Param("option") String option,
                              @Param("search") String search,
                              @Param("storage") String storage,
                              @Param("isAll") int isAll);
    @Query(value = "select * from product  where product_id = ?1", nativeQuery = true)
    Product findById(int id);
}
