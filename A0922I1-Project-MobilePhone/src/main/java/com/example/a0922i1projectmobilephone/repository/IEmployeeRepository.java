package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

}
