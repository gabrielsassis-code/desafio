package com.example.petshop.service;

import com.example.petshop.entity.Pet;
import com.example.petshop.exception.PetException;
import com.example.petshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet salvar(Pet pet){
        if (petRepository.existsByNome(pet.getNome())){
            throw new PetException("Pet já existe");
        }
        return petRepository.save(pet);
    }

    public Pet atualizar(Pet pet, Long id){
        if (!petRepository.existsById(id)){
            throw new PetException("Pet não existe");
        }
        pet.setId(id);
        return petRepository.save(pet);
    }

    public List<Pet> buscarTodos(){
        List<Pet> pets = petRepository.findAll();
        if(pets.isEmpty()){
            throw new PetException("Não existe pets");
        }

        return pets;
    }

    public Pet buscarPorId(Long id){
        Pet pet = petRepository.findById(id).orElseThrow(
                ()-> new PetException("Pet não existe")
        );
        return pet;
    }

    public List<Pet> buscarPorCliente(String nome){
        return petRepository.findAllByClienteNome(nome);
    }

    public void deletar(Long id){
        Pet pet = petRepository.findById(id).orElseThrow(
                ()-> new PetException("Pet não existe")
        );

        petRepository.delete(pet);
    }


}
