package com.javanar.realestate.repository;

import com.javanar.realestate.domain.Enums.RoleType;
import com.javanar.realestate.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepositrory extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleType name);
}
