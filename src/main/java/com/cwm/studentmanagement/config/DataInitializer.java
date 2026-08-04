package com.cwm.studentmanagement.config;

import com.cwm.studentmanagement.models.User;
import com.cwm.studentmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword("admin");
                user.setActive(true);

                userRepository.save(user);
            }
        };
    }
}