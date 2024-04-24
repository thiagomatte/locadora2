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
import com.example.locadorademo.model.Cliente;
import com.example.locadorademo.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/todos")
    public List<Cliente> getAllCliente() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        Optional<Cliente> opcao = repository.findById(id);
        return opcao.isPresent() ? opcao.get() : null;
    }
    
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PostMapping
    public Cliente postCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping
    public Cliente putCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }
}
