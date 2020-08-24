package com.example.server.Controller;

import com.example.server.Entity.CarBrand;
import com.example.server.Repository.CarBrandRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CarBrandController {
    private CarBrandRepository brandRepository;

    @GetMapping("/brands")
    public Collection<CarBrand> carBrands(){
        return brandRepository.findAll();
    }
}
