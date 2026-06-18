package net.javaguides.employee_backend.controller;

import net.javaguides.employee_backend.model.Employee;
import net.javaguides.employee_backend.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping()
    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }
}
