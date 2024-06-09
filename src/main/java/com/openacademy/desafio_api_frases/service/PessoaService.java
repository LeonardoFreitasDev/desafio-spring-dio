package com.openacademy.desafio_api_frases.service;

import com.openacademy.desafio_api_frases.model.Pessoa;

public interface PessoaService {
    Iterable<Pessoa> buscarTodos();

    Pessoa buscarPorId(Long id);

    void inserir(Pessoa pessoa);

    void atualizar(Long id, Pessoa pessoa);

    void deletar(Long id);
}
