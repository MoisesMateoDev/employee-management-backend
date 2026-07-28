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
    public ResponseEntity<List<EmployeeDTO>> readEmployees() {
        List<EmployeeDTO> employees = employeeService.readEmployees();
        if(employees == null){
            throw new ResourceNotFoundException("There are not employees on the system");
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> readEmployeeById(@PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.readEmployeeById(employeeId);
        if (employeeDTO.getId() == null) {
            throw new ResourceNotFoundException("The employee cannot be found. Employee not exist with employeeId> " + employeeId + " ");
        }
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTOReturned = new EmployeeDTO();
        if(employeeDTO != null){
            employeeDTOReturned = employeeService.updateEmployeeById(employeeId, employeeDTO);
        }
        if (employeeDTOReturned.getId() == null) {
            throw new ResourceNotFoundException("The employee cannot be updated. Employee not exist with employeeId> " + employeeId + " ");
        }
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long employeeId){
        EmployeeDTO existingEmployeeDTO = employeeService.readEmployeeById(employeeId);
        if( existingEmployeeDTO.getId() == null){
            throw new ResourceNotFoundException("The employee cannot be deleted. Employee not exist with employeeId> " + employeeId + " ");
        }
            employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
