package com.javanar.realestate.controller;

import com.javanar.realestate.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;





}
