package br.univille.sistemamercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sistemamercado.entity.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto,Long>{
    
}
