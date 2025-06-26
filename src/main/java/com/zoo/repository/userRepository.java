package com.zoo.repository;

import com.zoo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<User,String> {




}
