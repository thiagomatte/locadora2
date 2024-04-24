package com.example.locadorademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.locadorademo.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer>{
}
