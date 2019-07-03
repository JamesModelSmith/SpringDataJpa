package com.example.demo.repository;

import com.example.demo.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {
}
