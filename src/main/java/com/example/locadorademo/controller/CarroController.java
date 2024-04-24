package com.example.locadorademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.locadorademo.model.Carro;
import com.example.locadorademo.repository.CarroRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/carros")
public class CarroController{

    @Autowired
    private CarroRepository repository;

    @GetMapping("/todos")
    public List<Carro> getAllCarros() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Carro getCarroById(@PathVariable Integer id) {
        Optional<Carro> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }
    
    @DeleteMapping
    public void deleteCar(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PostMapping
    public Carro postCarro(@RequestBody Carro carro) {
        return repository.save(carro);
    }

    @PutMapping
    public Carro putCarro(@RequestBody Carro carro) {
        return repository.save(carro);
    }

}
