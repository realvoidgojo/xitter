package com.xitter;

import com.xitter.models.ApplicationUser;
import com.xitter.models.Role;
import com.xitter.repositories.RoleRepository;
import com.xitter.repositories.UserRepository;
import com.xitter.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class XitterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(XitterBackendApplication.class, args);
	}

    @Bean
    CommandLineRunner run(RoleRepository roleRepo, UserService userService) {
        return args -> {
            Role userRole = roleRepo.findByAuthority("USER")
                    .orElseGet(() -> roleRepo.save(new Role(null, "USER"))); // only insert if missing

//            ApplicationUser u = new ApplicationUser();
//            u.setUsername("unknown");
//            u.setLastName("player");
//            userService.registerUser(u);



        };
    }

}
