package com.example.portfilio;

import com.example.portfilio.model.User;
import com.example.portfilio.model.UserType;
import com.example.portfilio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PortfilioApplication implements CommandLineRunner {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(PortfilioApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = userRepository.findUserByEmail("admin@gmail.com");
        if (user == null) {
            User admin = User.builder()
                    .name("admin")
                    .surname("admin")
                    .phoneNumber("00000000")
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("admin"))
                    .repeatPassword(passwordEncoder.encode("admin"))
                    .build();
            userRepository.save(admin);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

