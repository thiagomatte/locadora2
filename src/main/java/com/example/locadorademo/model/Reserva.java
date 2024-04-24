package com.example.locadorademo.model;

import com.example.locadorademo.model.Reserva;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dataInicio;

    private String dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id")
    // @JsonBackReference
    private Carro carro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    // @JsonBackReference
    private Cliente cliente;

    public Reserva(String dataInicio, String dataFim, Carro carro, Cliente cliente) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.carro = carro;
        this.cliente = cliente;
    }

    public Reserva(){
    }

    public Integer getId() {
        return id;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
