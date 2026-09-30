package com.example.petshop.repository;

import com.example.petshop.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Produto findByNome(Long nome);
    boolean existsByNome(String nome);
    boolean existsById(Long id);
}
