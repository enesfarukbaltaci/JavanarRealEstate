package com.javanar.realestate.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30,nullable = false)
    private String firstName;

    @Column(length = 30,nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(length = 20,nullable = false)
    private String phoneNumber;

   @Column(nullable = false)
    private String address;

   @Column(length =300,nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean builtIn=false;

    @Column(length = 15,nullable = false)
    private String zipCode;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="tbl_user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles=new HashSet<>();

}
