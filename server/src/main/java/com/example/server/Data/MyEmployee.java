package com.example.server.Data;

import com.example.server.Entity.*;
import com.example.server.Repository.*;
import org.slf4j.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyEmployee implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyEmployee.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
    @Bean
    public ApplicationRunner employee(EmployeeRepository employeeRepository,
                                      EmployeeTypeRepository employeeTypeRepository){
        return (args -> {
            employeeTypeRepository.save(new EmployeeType("General"));
            employeeTypeRepository.save(new EmployeeType("Casual Worker"));


            employeeRepository.save(new Employee("Wan","Wara","1489900265725","0990050905","seal_recon_006@hotmail.com"));
//            employeeRepository.save(new Employee("IOkay","UOkay","1489900245725","0990050904","seal_recon_003@hotmail.com"));


        });
    }

}
