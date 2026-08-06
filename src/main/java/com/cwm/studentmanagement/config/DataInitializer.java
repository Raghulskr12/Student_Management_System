package com.cwm.studentmanagement.config;

import com.cwm.studentmanagement.models.User;
import com.cwm.studentmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin@123"));
                user.setActive(true);

                userRepository.save(user);
            }
        };
    }
}