package com.EmployeeManagement.mapper;

import com.EmployeeManagement.Entity.Employee;
import com.EmployeeManagement.dto.Employeedto;

public class Employeemapper {

    public static Employeedto mapToEmployeeDto(Employee employee){
        return new Employeedto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()

        );
    }

    public static Employee mapToEmployee(Employeedto employee){
        return new Employee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()

        );
    }
}
