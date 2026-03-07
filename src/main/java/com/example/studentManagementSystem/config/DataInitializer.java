package com.example.studentManagementSystem.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.studentManagementSystem.model.Role;
import com.example.studentManagementSystem.repository.RoleRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            // Check if STUDENT role exists, if not, create it
            if (roleRepository.findByRoleName("STUDENT").isEmpty()) {
                roleRepository.save(new Role(null, "STUDENT"));
                System.out.println("Inserted STUDENT role automatically.");
            }

            // Check if ADMIN role exists, if not, create it
            if (roleRepository.findByRoleName("ADMIN").isEmpty()) {
                roleRepository.save(new Role(null, "ADMIN"));
                System.out.println("Inserted ADMIN role automatically.");
            }
        };
    }
}
