package br.univille.sistemamercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sistemamercado.entity.ListaCompra;

@Repository
public interface ListaCompraRepository extends JpaRepository<ListaCompra,Long>{
 
}