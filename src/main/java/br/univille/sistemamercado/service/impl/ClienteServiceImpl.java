package br.univille.sistemamercado.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemamercado.entity.Cliente;
import br.univille.sistemamercado.repository.ClienteRepository;
import br.univille.sistemamercado.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<Cliente> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repositorio.save(cliente);
    }
    
}
