package br.univille.sistemamercado.service;

import java.util.List;
import br.univille.sistemamercado.entity.Entrega;

public interface EntregaService {
    List<Entrega>getAll();
    Entrega save(Entrega entrega);
    Entrega findById(long id);
    void delete(long id);
}
