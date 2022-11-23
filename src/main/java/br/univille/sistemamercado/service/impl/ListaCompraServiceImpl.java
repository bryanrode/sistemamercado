package br.univille.sistemamercado.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.sistemamercado.entity.ListaCompra;
import br.univille.sistemamercado.repository.ListaCompraRepository;
import br.univille.sistemamercado.service.ListaCompraService;

public class ListaCompraServiceImpl implements ListaCompraService{

    @Autowired
    private ListaCompraRepository repositorio;

    @Override
    public List<ListaCompra> getAll() {
        return repositorio.findAll();
    }

    @Override
    public ListaCompra save(ListaCompra listacompra) {
        return repositorio.save(listacompra);
    }

    @Override
    public ListaCompra findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new ListaCompra();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
