package com.openacademy.desafio_api_frases.service.impl;

import com.openacademy.desafio_api_frases.model.Citacao;
import com.openacademy.desafio_api_frases.model.CitacaoRepository;
import com.openacademy.desafio_api_frases.model.Pessoa;
import com.openacademy.desafio_api_frases.model.PessoaRepository;
import com.openacademy.desafio_api_frases.service.KanyeRestApiService;
import com.openacademy.desafio_api_frases.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CitacaoRepository citacaoRepository;

    @Autowired
    private KanyeRestApiService kanyeRestApiService;

    @Override
    public Iterable<Pessoa> buscarTodos() {
        System.out.println(kanyeRestApiService.getCitacao());
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.get();
    }

    @Override
    public void inserir(Pessoa pessoa) {
        salvarUserComCitacao(pessoa);
    }

    @Override
    public void atualizar(Long id, Pessoa pessoa) {
        Optional<Pessoa> userDataBase =  pessoaRepository.findById(id);
        if (userDataBase.isPresent()){
            salvarUserComCitacao(pessoa);
        }
    }

    @Override
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    private void salvarUserComCitacao(Pessoa pessoa){
        Citacao citacao = pessoa.getCitacao();
        if (citacao == null || citacao.getId() == null) {
            Citacao novaCitacao = kanyeRestApiService.getCitacao();
            if (novaCitacao != null) {
                citacaoRepository.save(novaCitacao);
                pessoa.setCitacao(novaCitacao);
            }
        } else {
            Long id = citacao.getId();
            Citacao citacaoExistente = citacaoRepository.findById(id).orElse(null);
            if (citacaoExistente == null) {
                citacaoRepository.save(citacao);
            }
        }
        // Salvando a pessoa no repositório
        pessoaRepository.save(pessoa);
    }
}
