package net.javaguides.employee_backend.service;

import net.javaguides.employee_backend.exception.ResourceNotFoundException;
import net.javaguides.employee_backend.mapper.EmployeeMapper;
import net.javaguides.employee_backend.model.Employee;
import net.javaguides.employee_backend.model.dto.EmployeeDTO;
import net.javaguides.employee_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public EmployeeDTO readEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();

        if(employee.isPresent()){
         employeeDTO = employeeMapper.toDto(employee.get());
       }
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            Employee employeeToRepo = employeeMapper.toEntity(employeeDTO);
            Employee employeeUpdated = employeeRepository.save(employeeToRepo);
            employeeDTO = employeeMapper.toDto(employeeUpdated);
        }
        return employeeDTO;
    }
}
