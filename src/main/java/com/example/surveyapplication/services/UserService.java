package com.example.surveyapplication.services;

import com.example.surveyapplication.models.Role;
import com.example.surveyapplication.models.User;
import com.example.surveyapplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
@PropertySource("classpath:/properties/user.properties")
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${defaultUserRoleOrd}")
    private int defaultRoleOrd;

    public void saveNewUser(User user){
        addDefaultRoleToUser(user);
        encodePassword(user);
        userRepository.save(user);
    }

    private void addDefaultRoleToUser(User user){
        Role role = Role.values()[defaultRoleOrd];
        Set<Role> rolesSet = Collections.singleton(role);
        user.setRoles(rolesSet);
    }

    private void encodePassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public User receiveCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Long receiveCurrentUserId(){
        return receiveCurrentUser().getId();
    }


    public boolean isCurrentUser(Long id){
        return receiveCurrentUserId().equals(id);
    }

    public boolean isUsernameUnique(String username){
        return userRepository.findByUsername(username).isEmpty();
    }
}
