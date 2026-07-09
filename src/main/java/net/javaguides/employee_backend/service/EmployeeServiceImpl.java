package net.javaguides.employee_backend.service;

import net.javaguides.employee_backend.mapper.EmployeeMapper;
import net.javaguides.employee_backend.model.Employee;
import net.javaguides.employee_backend.model.dto.EmployeeDTO;
import net.javaguides.employee_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee employeeResponse = employeeRepository.save(employee);
        employeeDTO.setId(employeeResponse.getId());
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> readEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDtoList(employees);
    }
}
