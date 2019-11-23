package com.example.hibernateLogin.repositories;

import com.example.hibernateLogin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
}
