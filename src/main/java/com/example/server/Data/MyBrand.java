package com.example.server.Data;

import com.example.server.Entity.CarBrand;
import com.example.server.Repository.CarBrandRepository;
import org.slf4j.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBrand implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyBrand.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
    @Bean
    public ApplicationRunner brand(CarBrandRepository brandRepository){
        return (args -> {
            brandRepository.save(new CarBrand("BMW"));
            brandRepository.save(new CarBrand("TOYOTA"));
        });
    }


}
