package net.javaguides.employee_backend.controller;

import net.javaguides.employee_backend.model.Employee;
import net.javaguides.employee_backend.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }
}
