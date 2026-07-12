package net.javaguides.employee_backend.controller;


import net.javaguides.employee_backend.exception.ResourceNotFoundException;
import net.javaguides.employee_backend.model.dto.EmployeeDTO;
import net.javaguides.employee_backend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> readEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> readEmployeeById(@PathVariable Long id){
        EmployeeDTO employeeDTO = employeeService.readEmployeeById(id);
        if (employeeDTO == null) {
            throw new ResourceNotFoundException("Employee not exist with id :" + id);
        }
        return ResponseEntity.ok(employeeDTO);
    }

}
