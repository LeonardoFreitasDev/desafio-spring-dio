package com.openacademy.desafio_api_frases.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitacaoRepository extends CrudRepository<Citacao, Long> {
}
