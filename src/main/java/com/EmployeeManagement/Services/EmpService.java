package com.EmployeeManagement.Services;

import com.EmployeeManagement.dto.Employeedto;
import java.util.*;
public interface EmpService {

    Employeedto createEmployee(Employeedto employeedto);

    Employeedto getEmployeeById(Long id);

    List<Employeedto> getAllEmployees();

    Employeedto updateEmployee(Long id,Employeedto employeedto);

    void deleteEmployee(Long id);
}
