package com.javanar.realestate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;

    private String lastname;

    private String email;

    private String phoneNumber;

    private String address;

    private String password;

    private Boolean builtIn=false;

    private String zipCode;





}