package com.example.server.Repository;

import com.example.server.Entity.StatusActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface StatusActiveRepository extends JpaRepository<StatusActive,Long> {
    StatusActive findByStatusName(String statusName);
}
