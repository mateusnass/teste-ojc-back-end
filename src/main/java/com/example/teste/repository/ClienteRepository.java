package com.example.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.entity.User;


@Repository
public interface ClienteRepository extends JpaRepository<User, Long> {

}
