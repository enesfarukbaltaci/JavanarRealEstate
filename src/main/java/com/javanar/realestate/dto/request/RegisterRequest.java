package com.javanar.realestate.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

   @Size(max = 30)
   @NotNull(message = "Please provide your firstName ")
    private String firstName;

    @Size(max = 30)
    @NotNull(message = "Please provide your lastName ")
    private String lastName;

    @Email
    @Size(min = 1,max = 50)
    @NotNull(message ="Please provide your Email")
    private String email;


    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please provide valid phone number")
    @Size(min = 14, max = 14)
    @NotNull(message = "Please provide your phone number")
    private String phoneNumber;

    @NotNull(message = "Please provide your Address")
    private String address;

    @Size(min = 8,max = 300, message = "Please provide your password")
    @NotNull(message = "Please provide your passsword")
    private String password;

    private Boolean builtIn=false;

    @Size(max = 15)
    @NotNull(message = "Please provide your Address")
    private String zipCode;


}
