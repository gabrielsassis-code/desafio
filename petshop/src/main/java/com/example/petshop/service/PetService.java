package com.example.petshop.service;

import com.example.petshop.dto.ResponsePetDTO;
import com.example.petshop.entity.Pet;
import com.example.petshop.exception.PetException;
import com.example.petshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public ResponsePetDTO transformar(Pet pet){
        ResponsePetDTO dto = new ResponsePetDTO();
        dto.setNome(pet.getNome());
        dto.setId(pet.getId());
        dto.setIdCliente(pet.getCliente().getId());
        dto.setRaca(pet.getRaca());
        dto.setEspecie(pet.getEspecie());
        return dto;
    }

    public ResponsePetDTO salvar(Pet pet){
        if (petRepository.existsByNome(pet.getNome())){
            throw new PetException("Pet já existe");
        }
        return transformar(petRepository.save(pet));
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

    public List<ResponsePetDTO> buscarPorCliente(String nome){
        List<Pet> pets =petRepository.findAllByClienteNome(nome);
        List<ResponsePetDTO> ListDto = new ArrayList<>();

        for(Pet pet:pets){
            ResponsePetDTO petDto = transformar(pet);
            ListDto.add(petDto);
        }
        return ListDto;
    }

    public void deletar(Long id){
        Pet pet = petRepository.findById(id).orElseThrow(
                ()-> new PetException("Pet não existe")
        );

        petRepository.delete(pet);
    }


}
