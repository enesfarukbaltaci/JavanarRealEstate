package com.javanar.realestate.service;


import com.javanar.realestate.domain.Enums.RoleType;
import com.javanar.realestate.domain.Role;
import com.javanar.realestate.domain.User;
import com.javanar.realestate.dto.request.RegisterRequest;
import com.javanar.realestate.exception.ConflictException;
import com.javanar.realestate.exception.ResourceNotFoundException;
import com.javanar.realestate.exception.message.ErrorMessage;
import com.javanar.realestate.repository.RoleRepositrory;
import com.javanar.realestate.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepositrory roleRepositrory;



public void register (RegisterRequest registerRequest){

    if (userRepository.existsByEmail(registerRequest.getEmail())){
        throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST, registerRequest.getEmail()));
    }

    Role role=roleRepositrory.findByName(RoleType.ROLE_USER).
            orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.ROLE_NOT_FOUND_MESSAGE, RoleType.ROLE_USER.name())));

    String encodepassword=passwordEncoder.encode(registerRequest.getPassword());

    Set<Role> roles=new HashSet<>();
    roles.add(role);

    User user=new User();
    user.setFirstName(registerRequest.getFirstName());
    user.setLastName(registerRequest.getLastName());
    user.setAddress(registerRequest.getAddress());
    user.setPassword(encodepassword);
   user.setPhoneNumber(registerRequest.getPhoneNumber());
   user.setZipCode(registerRequest.getZipCode());
   user.setEmail(registerRequest.getEmail());
   user.setRoles(roles);

   userRepository.save(user);

}

}
