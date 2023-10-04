package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IRepositoryCustomer extends JpaRepository<Customer, Integer> {

    @Query(value = "select customer_id, customer_phone, customer_name , customer_address, customer_age, customer_email " +
            " from customer " +
            "WHERE\n" +
            "    (\n" +
            "        (:option = 'name' AND customer_name LIKE %:search%) OR\n" +
            "        (:option = 'age' AND customer_age  = :search) OR\n" +
            "        (:option = 'address' AND customer_address LIKE %:search%)\n" +
            "    )\n" +
            "    OR :isAll = 1" +
            "    OR customer_phone LIKE %:numberPhone%\n", nativeQuery = true)
    Page<Customer> searchCustomer(Pageable pageable, @Param("option") String option,
                                  @Param("search") String search,
                                  @Param("numberPhone") String numberPhone,
                                  @Param("isAll") int isAll);
    @Query(value = "select * from customer  where customer_id = ?1", nativeQuery = true)
    Customer findById(int id);

}