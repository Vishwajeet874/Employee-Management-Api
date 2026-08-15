package com.EmployeeManagement.controller;

import com.EmployeeManagement.Entity.Employee;
import com.EmployeeManagement.Services.EmpService;
import com.EmployeeManagement.dto.Employeedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmpController {

    @Autowired
    private EmpService empservice;

    @GetMapping("/view")
    @ResponseBody
    public String getIdparams(@RequestParam String id) {
        return "ID: " + id;
    }
    @PostMapping
    public ResponseEntity<Employeedto>  createEmployee(@RequestBody Employeedto employeedto){
        Employeedto saved=empservice.createEmployee(employeedto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employeedto> getEmployeeById(@PathVariable Long id){
        Employeedto employeeById = empservice.getEmployeeById(id);
        return ResponseEntity.ok(employeeById);
    }

    @GetMapping
    public ResponseEntity<List<Employeedto>> getAllEmployees(){
        List<Employeedto> allEmployees = empservice.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employeedto> update(@PathVariable Long id, @RequestBody Employeedto employeedto){
        Employeedto employeedto1 = empservice.updateEmployee(id, employeedto);
        return ResponseEntity.ok(employeedto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        empservice.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
