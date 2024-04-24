package com.example.locadorademo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.locadorademo.model.Reserva;
import com.example.locadorademo.repository.ReservaRepository;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository repository;

    @GetMapping("/todos")
    public List<Reserva> getAllReservas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Reserva getReservaById(@PathVariable Integer id) {
        Optional<Reserva> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }
    
    @DeleteMapping
    public void deleteReserva(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PostMapping
    public Reserva postReserva(@RequestBody Reserva reserva) {
        return repository.save(reserva);
    }

    @PutMapping
    public Reserva putReserva(@RequestBody Reserva reserva) {
        return repository.save(reserva);
    }
}

