package com.example.locadorademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.locadorademo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
