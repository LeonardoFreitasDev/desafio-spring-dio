package com.openacademy.desafio_api_frases.model;

import jakarta.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToOne
    private Citacao citacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Citacao getCitacao() {
        return citacao;
    }

    public void setCitacao(Citacao citacao) {
        this.citacao = citacao;
    }
}
