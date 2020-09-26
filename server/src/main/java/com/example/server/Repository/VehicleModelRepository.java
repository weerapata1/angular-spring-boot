package com.example.server.Repository;

import com.example.server.Entity.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface VehicleModelRepository extends JpaRepository<VehicleModel,Long> {
    List<VehicleModel> findByName(String name);

}
