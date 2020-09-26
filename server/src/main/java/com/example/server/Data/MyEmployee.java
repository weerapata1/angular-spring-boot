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
            Employee employee = new Employee();
            employeeRepository.save(new Employee("Weerapat","Taweesak","1489900245724","0990050905","seal_recon_006@hotmail.com",employeeTypeRepository.findByNameType("General")));
            employeeRepository.save(new Employee("IOkay","UOkay","1489900245725","0990050904","seal_recon_003@hotmail.com",employeeTypeRepository.findByNameType("Casual Worker")));

        });
    }

}
