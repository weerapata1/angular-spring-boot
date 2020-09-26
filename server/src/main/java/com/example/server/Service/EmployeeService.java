package com.example.server.Service;

import com.example.server.Entity.Employee;
import com.example.server.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Collection<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> findByFirstName(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }
    public Optional<Employee> findByLastName(String lastName){
        return employeeRepository.findByLastName(lastName);
    }
    public ResponseEntity<Employee> findById(Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(employee);
    }

    public ResponseEntity<Employee> store(MultipartFile file ,Long id)throws ResourceNotFoundException{
        Employee employees = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found :: "+id));

       return ResponseEntity.ok().body(employees);
    }
}
