package com.example.locadorademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.locadorademo.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
