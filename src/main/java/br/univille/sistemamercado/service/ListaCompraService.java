package br.univille.sistemamercado.service;

import java.util.List;
import br.univille.sistemamercado.entity.ListaCompra;

public interface ListaCompraService {
    List<ListaCompra>getAll();
    ListaCompra save(ListaCompra listacompra);
    ListaCompra findById(long id);
}
