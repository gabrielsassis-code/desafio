package com.example.petshop.repository;

import com.example.petshop.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    Pet findByNome(String nome);
    List<Pet> findAllByClienteNome(String nome);
    boolean existsByNome(String nome);
    boolean existsById(Long id);
}
