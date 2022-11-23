package br.univille.sistemamercado.service;

import java.util.List;
import br.univille.sistemamercado.entity.Fornecedor;

public interface FornecedorService {
    List<Fornecedor>getAll();
    Fornecedor save(Fornecedor fornecedor);
    Fornecedor findById(long id);
    void delete(long id);
}
