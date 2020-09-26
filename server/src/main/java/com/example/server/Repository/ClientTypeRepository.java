package com.example.server.Repository;

import com.example.server.Entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientTypeRepository extends JpaRepository <ClientType, Long> {
    ClientType findByNameType(String nameType);
}
