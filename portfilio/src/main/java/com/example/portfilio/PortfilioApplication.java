package com.example.portfilio;

import com.example.portfilio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PortfilioApplication{
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(PortfilioApplication.class, args);
    }

//    @Override
//    public void run(String... strings) throws Exception {
//        User user = userRepository.findUserByEmail("admin@mail.com");
//        if (user == null) {
//            User admin = User.builder()
//                    .email("admin@mail.com")
//                    .name("admin")
//                    .surname("admin")
//                    .password(passwordEncoder.encode("admin"))
//                    .type(com.example.portfilio.model.UserType.ADMIN)
//                    .build();
//            userRepository.save(admin);
//        }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
