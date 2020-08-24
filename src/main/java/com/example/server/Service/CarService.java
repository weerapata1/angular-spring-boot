package com.example.server.Service;

import com.example.server.Entity.Car;
import com.example.server.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class CarService {
    @Autowired private CarRepository carRepository;
    public Car findById(Long id){
        return carRepository.getOne(id);
    }
    public Collection<Car> findAll(){
        return carRepository.findAll();
    }
    public Optional<Car> findBySerialNo(String serialNo){
        return carRepository.findBySerialNo(serialNo);
    }
    public Car store(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains(".."))
                return null;
            Car car = Car.builder()
                    .fileName(fileName)
                    .fileType(file.getContentType())
                    .data(file.getBytes())
                    .build();
            return carRepository.save(car);
        }catch (IOException e){
            e.getStackTrace();
            return null;
        }
    }
    public ResponseEntity<InputStreamResource> previewById(Long id){
        Car car = findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(car.getFileType()))
                .body(new InputStreamResource(new ByteArrayInputStream(car.getData())));
    }
    public ResponseEntity<Car> findByIdz(Long idx) throws ResourceNotFoundException {
        Car car = carRepository.findById(idx)
                .orElseThrow(()-> new ResourceNotFoundException("Car not found for this id :: "+ idx));
        return ResponseEntity.ok().body(car);
    }
}
