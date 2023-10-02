package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Employee;
import com.example.a0922i1projectmobilephone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT e.nameEmployee  FROM Employee e WHERE e.nameEmployee = :nameEmployee", nativeQuery = true)
    Employee findByNameEmployee(@Param("nameEmployee") String nameEmployee);

}
