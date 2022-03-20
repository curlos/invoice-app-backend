package com.example.invoiceapp.repository;

import com.example.invoiceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE email=:email")
    User findByEmail(@Param("email") String email);
}
