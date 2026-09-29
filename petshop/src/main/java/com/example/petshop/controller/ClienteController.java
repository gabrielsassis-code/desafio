package com.example.petshop.controller;

import com.example.petshop.entity.Cliente;
import com.example.petshop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> todos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        return ResponseEntity.ok(clienteService.atualizar(cliente,id));
    }
    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }


}
