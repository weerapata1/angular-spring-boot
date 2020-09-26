package com.example.server.Repository;

import com.example.server.Entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType , Long> {
    EmployeeType findByNameType(String nameType);
}
