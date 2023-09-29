package com.example.a0922i1projectmobilephone.service.Impl;

import com.example.a0922i1projectmobilephone.entity.Employee;
import com.example.a0922i1projectmobilephone.repository.IEmployeeRepository;
import com.example.a0922i1projectmobilephone.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}