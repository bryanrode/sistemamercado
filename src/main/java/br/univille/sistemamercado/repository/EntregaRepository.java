package br.univille.sistemamercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sistemamercado.entity.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long>{
 
}