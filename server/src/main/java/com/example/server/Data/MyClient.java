package com.example.server.Data;

import com.example.server.Entity.*;
import com.example.server.Repository.*;
import org.slf4j.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyClient implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyClient.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
    @Bean
    public ApplicationRunner client(ClientTypeRepository clientTypeRepository,
                                   ClientRepository clientRepository){
        return (args -> {
            /*****-----> ClientType <------*****/
            clientTypeRepository.save(new ClientType("General"));
            clientTypeRepository.save(new ClientType("Exclusive"));

            /*****-----> Client <------*****/
            clientRepository.save(new Client("Weerapat","Taweesak","1489900265275",clientTypeRepository.findByNameType("General")));
            clientRepository.save(new Client("Angly","Bob","1489900265274",clientTypeRepository.findByNameType("General")));
            clientRepository.save(new Client("Nanthika","Poonpin","1234567890123",clientTypeRepository.findByNameType("Exclusive")));
        });
    }


}
