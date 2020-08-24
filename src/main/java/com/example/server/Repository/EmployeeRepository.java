package com.example.server.Repository;

import com.example.server.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee , Long> {
    Optional<Employee> findByFirstName(String firstName);
    Optional<Employee> findByLastName(String lastName);
}
