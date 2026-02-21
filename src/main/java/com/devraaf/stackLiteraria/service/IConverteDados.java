package com.devraaf.stackLiteraria.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
