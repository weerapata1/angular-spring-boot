package com.example.server.Data;

import com.example.server.Entity.*;
import com.example.server.Repository.*;
import org.slf4j.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class MyVehicle implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyVehicle.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {}
    @Bean
    public ApplicationRunner Vehicle(VehicleTypeRepository vehicleTypeRepository,VehicleBrandRepository brandRepository,
                                     VehicleColorRepository vehicleColorRepository){
        return (args -> {
            /*****-----> VehicleType <------*****/
            Stream.of("truck","MotoBike","SUV","MPV","Sport","Supercar","Touring").forEach(name ->{
                VehicleType vehicleType = new VehicleType();
                vehicleType.setNameType(name);
                vehicleTypeRepository.save(vehicleType);
            });

            /*****-----> VehicleBrand <------*****/
            Stream.of("BMW","TOYOTA","HONDA").forEach(name ->{
                VehicleBrand vehicleBrand = new VehicleBrand();
                vehicleBrand.setName(name);
                brandRepository.save(vehicleBrand);
            });
            /*****-----> VehicleColor <------*****/
            Stream.of("red","white","black").forEach(color ->{
                VehicleColor vehicleColor = new VehicleColor();
                vehicleColor.setColor(color);
                vehicleColorRepository.save(vehicleColor);
            });

        });
    }
}
