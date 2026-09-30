package com.example.petshop.controller;

import com.example.petshop.entity.Produto;
import com.example.petshop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @GetMapping("/")
    public ResponseEntity<List<Produto>> todos(){
        return ResponseEntity.ok(produtoService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Long id){
        return ResponseEntity.ok(produtoService.atualizar(produto,id));
    }
    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }


}
