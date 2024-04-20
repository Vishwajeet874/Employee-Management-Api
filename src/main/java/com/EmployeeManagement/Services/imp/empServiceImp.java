package com.EmployeeManagement.Services.imp;

import com.EmployeeManagement.Entity.Employee;
import com.EmployeeManagement.Services.EmpService;
import com.EmployeeManagement.dto.Employeedto;
import com.EmployeeManagement.exception.ResourceNotFoundException;
import com.EmployeeManagement.mapper.Employeemapper;
import com.EmployeeManagement.repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class empServiceImp implements EmpService {

    @Autowired
    private EmpRepository repo;
    @Override
    public Employeedto createEmployee(Employeedto employeedto) {
        Employee employee= Employeemapper.mapToEmployee(employeedto);
        Employee employee1=repo.save(employee);
        return Employeemapper.mapToEmployeeDto(employee1);
    }

    @Override
    public Employeedto getEmployeeById(Long id) {
        Employee employee=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found by id"));
        return Employeemapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<Employeedto> getAllEmployees() {
        List<Employee> all = repo.findAll();
        return all.stream().map((employee) -> Employeemapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public Employeedto updateEmployee(Long id, Employeedto employeedto) {
        Employee employee=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found by id"));
        employee.setFirstName(employeedto.getFirstName());
        employee.setLastName(employeedto.getLastName());
        employeedto.setEmail(employeedto.getEmail());


        Employee save = repo.save(employee);
        return Employeemapper.mapToEmployeeDto(save);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found by id"));
        repo.deleteById(id);
    }
}
