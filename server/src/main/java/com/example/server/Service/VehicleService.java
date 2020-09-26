package com.example.server.Service;

import com.example.server.Entity.*;
import com.example.server.Repository.*;
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

@Service
public class VehicleService {
    @Autowired private ImageVehicleRepository imageVehicleRepository;
    public ImageVehicle findById(Long id){
        return imageVehicleRepository.getOne(id);
    }
    public Collection<ImageVehicle> findAll(){
        return imageVehicleRepository.findAll();
    }
    public ImageVehicle store(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains(".."))
                return null;
            ImageVehicle imageVehicle = ImageVehicle.builder()
                    .fileName(fileName)
                    .fileType(file.getContentType())
                    .data(file.getBytes())
                    .build();
            return imageVehicleRepository.save(imageVehicle);
        }catch (IOException e){
            e.getStackTrace();
            return null;
        }
    }
    public ResponseEntity<InputStreamResource> previewById(Long id){
        ImageVehicle imageVehicle = findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageVehicle.getFileType()))
                .body(new InputStreamResource(new ByteArrayInputStream(imageVehicle.getData())));
    }
    public ResponseEntity<ImageVehicle> findByIdz(Long idx) throws ResourceNotFoundException {
        ImageVehicle imageVehicle = imageVehicleRepository.findById(idx)
                .orElseThrow(()-> new ResourceNotFoundException("Vehicle not found for this id :: "+ idx));
        return ResponseEntity.ok().body(imageVehicle);
    }
}
