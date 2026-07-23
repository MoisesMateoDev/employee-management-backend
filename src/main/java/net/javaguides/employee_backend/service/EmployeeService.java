package net.javaguides.employee_backend.service;

import net.javaguides.employee_backend.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

 EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
 List<EmployeeDTO> readEmployees();
 EmployeeDTO readEmployeeById(Long id);
 EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO);
 void deleteEmployeeById(Long id);
}
