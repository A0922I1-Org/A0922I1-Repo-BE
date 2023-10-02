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

    @Query(value = "select customer_id, customer_phone, customer_name , customer_address, customer_age, customer_email from customer", nativeQuery = true)
    Page<Customer> getAllCustomers(Pageable pageable);
    @Query(value = "SELECT\n" +
            "    CASE\n" +
            "        WHEN :option = 'customer_name' THEN customer_name\n" +
            "        WHEN :option = 'customer_age' THEN CAST(customer_age AS VARCHAR)\n" +
            "        WHEN :option = 'customer_address' THEN customer_address\n" +
            "    END AS search_result\n" +
            "FROM customer\n" +
            "WHERE\n" +
            "    (\n" +
            "        (:option = 'customer_name' AND customer_name LIKE '%' || :string || '%') OR\n" +
            "        (:option = 'customer_age' AND CAST(customer_age AS VARCHAR) LIKE '%' || :string || '%') OR\n" +
            "        (:option = 'customer_address' AND customer_address LIKE '%' || :string || '%')\n" +
            "    )\n" +
            "    OR customer_phone LIKE '%' || :numberPhone || '%';\n", nativeQuery = true)
    Page<Customer> searchCustomer(Pageable pageable, @Param("option") String option,
                                  @Param("string") String string,
                                  @Param("numberPhone") String numberPhone);

}
