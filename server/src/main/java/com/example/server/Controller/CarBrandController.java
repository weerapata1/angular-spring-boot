package com.example.server.Controller;

import com.example.server.Entity.VehicleBrand;
import com.example.server.Repository.VehicleBrandRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CarBrandController {
    private VehicleBrandRepository brandRepository;

    @GetMapping("/brands")
    public Collection<VehicleBrand> carBrands(){
        return brandRepository.findAll();
    }
}
