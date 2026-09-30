package com.example.petshop.controller;

import com.example.petshop.entity.Pet;
import com.example.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {
    @Autowired
    PetService petService;
    @GetMapping("/")
    public ResponseEntity<List<Pet>> todos(){
        return ResponseEntity.ok(petService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(petService.buscarPorId(id));
    }
    @GetMapping("/{nome}")
    public ResponseEntity<List<Pet>> buscarPorCliente(@PathVariable String nome){
        return ResponseEntity.ok(petService.buscarPorCliente(nome));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pet> atualizar(@RequestBody Pet pet, @PathVariable Long id){
        return ResponseEntity.ok(petService.atualizar(pet,id));
    }
    @PostMapping("/salvar")
    public ResponseEntity<Pet> salvar(@RequestBody Pet pet){
        return ResponseEntity.ok(petService.salvar(pet));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        petService.deletar(id);
    }


}
