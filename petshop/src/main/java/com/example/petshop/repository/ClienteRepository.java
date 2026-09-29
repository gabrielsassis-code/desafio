package com.example.petshop.repository;

import com.example.petshop.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findByNome(Long nome);
    boolean existsByNome(String nome);
    boolean existsById(Long id);
}
