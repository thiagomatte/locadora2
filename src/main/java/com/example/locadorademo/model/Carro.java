package com.example.locadorademo.model;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;

    @Column(nullable = false, unique = true)
    private String placa;
    
    private int ano;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    // @JsonManagedReference
    private List<Reserva> reservas;

    public Carro(String modelo, String placa, int ano, List<Reserva> reservas) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.reservas = reservas;
    }

    public Carro(){
    }

    public Integer getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
