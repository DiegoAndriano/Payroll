package com.example.Payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {
        return args -> {
            repository.save(new Employee("Palta", "Tremenda"));
            repository.save(new Employee("Cordelia", "Tremenda"));
            repository.save(new Employee("Lady Macbeth", "Dramática"));

            repository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("Beauty", Status.COMPLETED));
            orderRepository.save(new Order("Royal Canin Weight Control", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
