package com.example.server.Repository;

import com.example.server.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface CarRepository extends JpaRepository <Car , Long> {
    Optional<Car> findBySerialNo(String serialNo);
}
