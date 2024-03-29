package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeCrudRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;
    @Transactional
    public void update(Integer id,Integer age){
        employeeRepository.update(id,age);
    }
    @Transactional
    public void save(List<Employee> employees){
        employeeCrudRepository.save(employees);
    }
}
