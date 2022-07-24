package com.javanar.realestate.controller;


import com.javanar.realestate.dto.request.RegisterRequest;
import com.javanar.realestate.dto.response.GRResponse;
import com.javanar.realestate.dto.response.ResponseMessage;
import com.javanar.realestate.security.jwt.JwtUtils;
import com.javanar.realestate.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserJWTController {

    private UserService userService;

    JwtUtils jwtUtils;



    @PostMapping("/register")
    public ResponseEntity<GRResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        userService.register(registerRequest);

        GRResponse response= new GRResponse();
        response.setMessage(ResponseMessage.REGISTER_RESPONSE_MESSAGE);
        response.setSuccess(true);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }



}
