package com.example.hibernateLogin.repositories;

import com.example.hibernateLogin.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
