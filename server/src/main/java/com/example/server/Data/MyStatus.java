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
public class MyStatus implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyStatus.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {}
    @Bean
    public ApplicationRunner brand(StatusActiveRepository statusActiveRepository
                                  ){
        return (args -> {
            Stream.of("Available","Out Of Stock").forEach(name ->{
                StatusActive statusActive = new StatusActive();
                statusActive.setStatusName(name);
                statusActiveRepository.save(statusActive);
            });
        });
    }


}
