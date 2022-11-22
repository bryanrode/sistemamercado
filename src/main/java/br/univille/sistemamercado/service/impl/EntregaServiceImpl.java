package br.univille.sistemamercado.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemamercado.entity.Entrega;
import br.univille.sistemamercado.repository.EntregaRepository;
import br.univille.sistemamercado.service.EntregaService;

@Service
public class EntregaServiceImpl  implements EntregaService{

    @Autowired
    private EntregaRepository repositorio;

    @Override
    public List<Entrega> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Entrega save(Entrega entrega) {
        return repositorio.save(entrega);
    }

    @Override
    public Entrega findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }

        return new Entrega();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
