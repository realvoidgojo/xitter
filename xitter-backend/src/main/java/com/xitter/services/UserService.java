package com.xitter.services;

import com.xitter.models.ApplicationUser;
import com.xitter.models.Role;
import com.xitter.repositories.RoleRepository;
import com.xitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    @Autowired
    public UserService(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public ApplicationUser  registerUser(ApplicationUser user){
        Set<Role> roles = user.getAuthorities();
        roles.add(roleRepo.findByAuthority("USER").get());
        user.setAuthorities(roles);
        return userRepo.save(user);
    }
}
