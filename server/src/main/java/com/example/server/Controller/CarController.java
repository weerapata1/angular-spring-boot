//package com.example.server.Controller;
//
//import com.example.server.Entity.Vehicle;
//import com.example.server.Repository.*;
//import com.example.server.Repository.StatusActiveRepository;
//import com.example.server.Service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Collection;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
//public class CarController {
//    @Autowired private VehicleRepository vehicleRepository;
//    @Autowired private VehicleModelRepository modelRepository;
//    @Autowired private VehicleBrandRepository brandRepository;
//    @Autowired private StatusActiveRepository activeRepository;
////    @Autowired private VehicleService carService;
//
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
////    @GetMapping("/cars")
////    public Collection<Vehicle> findAll(){
////        return carService.findAll();
////    }
////    @GetMapping("/car/{id}")
////    public ResponseEntity<Vehicle> getCarById(@PathVariable(value = "id")Long id){
////        return carService.findByIdz(id);
////    }
//    @PostMapping("/cars")
//    public Vehicle createCar(@Valid @RequestBody Vehicle vehicle, @Valid @RequestParam(required = false) LocalDate carOut){
//
//        System.out.println(vehicle);
//        return vehicleRepository.save(vehicle);
//    }
//
//    @PutMapping("/vehicle/{id}")
//    public ResponseEntity<Vehicle> editCar(@PathVariable(value = "id") Long carId,
//                                           @Valid @RequestBody Vehicle vehicle) throws ResourceNotFoundException {
//        Vehicle newVehicle = vehicleRepository.findById(carId)
//                .orElseThrow(()->new ResourceNotFoundException("Vehicle not found for this ID :: " + carId));
//
//        newVehicle.setPlateNo(vehicle.getPlateNo());
//        newVehicle.setCarIn(vehicle.getCarIn());
//        newVehicle.setCarOut(vehicle.getCarOut());
//        newVehicle.setPrice(vehicle.getPrice());
//        newVehicle.setYear(vehicle.getYear());
////        newVehicle.setCarModel(vehicle.getCarModel());
////        newVehicle.setCarBrand(vehicle.getCarBrand());
//
//        final Vehicle updateVehicle = vehicleRepository.save(newVehicle);
//        return ResponseEntity.ok(updateVehicle);
//    }
//}
