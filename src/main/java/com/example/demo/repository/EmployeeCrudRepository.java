package com.example.demo.repository;

import com.example.demo.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer> {
}
