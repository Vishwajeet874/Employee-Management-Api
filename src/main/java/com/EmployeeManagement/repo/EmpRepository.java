package com.EmployeeManagement.repo;

import com.EmployeeManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EmpRepository extends JpaRepository<Employee,Long> {

}
