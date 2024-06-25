package net.java.springboot_backend.controller;

import net.java.springboot_backend.exception.ResourceNotFoundException;
import net.java.springboot_backend.model.Employee;
import net.java.springboot_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//it is used to develop the rest a
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //build get employee by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(long id)
    {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee not exist with id:" + id ));
        return ResponseEntity.ok(employee);
    }
    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"  +id ));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

    }
    //build delete employee rest API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
    {
Employee employee = employeeRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:" + id));
employeeRepository.delete(employee);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
