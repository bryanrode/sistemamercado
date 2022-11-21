package br.univille.sistemamercado.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemamercado.entity.Produto;
import br.univille.sistemamercado.repository.ProdutoRepository;
import br.univille.sistemamercado.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    public ProdutoRepository repositorio;

    @Override
    public List<Produto> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        return repositorio.save(produto);
    }

    @Override
    public Produto findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Produto();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
