package com.devraaf.stackLiteraria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBusca(
        List<DadosLivro> results
) {}
