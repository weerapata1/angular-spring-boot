package com.example.server.Controller;

import com.example.server.Entity.Car;
import com.example.server.Repository.*;
import com.example.server.Repository.StatusActiveRepository;
import com.example.server.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CarController {
    @Autowired private CarRepository carRepository;
    @Autowired private CarModelRepository modelRepository;
    @Autowired private CarBrandRepository brandRepository;
    @Autowired private StatusActiveRepository activeRepository;
    @Autowired private CarService carService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
    @GetMapping("/cars")
    public Collection<Car> findAll(){
        return carService.findAll();
    }
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id")Long id){
        return carService.findByIdz(id);
    }
    @PostMapping("/cars")
    public  Car createCar(@Valid @RequestBody Car car, @Valid @RequestParam(required = false) LocalDate carOut){

        System.out.println(car);
        return carRepository.save(car);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Car> editCar(@PathVariable(value = "id") Long carId,
                                       @Valid @RequestBody Car car) throws ResourceNotFoundException {
        Car newCar = carRepository.findById(carId)
                .orElseThrow(()->new ResourceNotFoundException("Car not found for this ID :: " + carId));

        newCar.setPlateNo(car.getPlateNo());
        newCar.setCarIn(car.getCarIn());
        newCar.setCarOut(car.getCarOut());
        newCar.setPrice(car.getPrice());
        newCar.setYear(car.getYear());
//        newCar.setCarModel(car.getCarModel());
//        newCar.setCarBrand(car.getCarBrand());

        final Car updateCar = carRepository.save(newCar);
        return ResponseEntity.ok(updateCar);
    }
}
