package br.univille.sistemamercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sistemamercado.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
 
}
