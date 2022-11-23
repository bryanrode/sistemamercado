package br.univille.sistemamercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sistemamercado.entity.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long>{
 
}