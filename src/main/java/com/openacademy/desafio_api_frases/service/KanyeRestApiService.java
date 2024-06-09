package com.openacademy.desafio_api_frases.service;

import com.openacademy.desafio_api_frases.model.Citacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "kanyerest", url = "https://api.kanye.rest")
public interface KanyeRestApiService {
    @GetMapping
    Citacao getCitacao();
}
