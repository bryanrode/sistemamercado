package br.univille.sistemamercado.service;

import java.util.List;

import br.univille.sistemamercado.entity.Cliente;

public interface ClienteService {
    List<Cliente>getAll();
    Cliente save(Cliente cliente);
}