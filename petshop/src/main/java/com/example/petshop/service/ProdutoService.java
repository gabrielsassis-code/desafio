package com.example.petshop.service;

import com.example.petshop.entity.Produto;
import com.example.petshop.exception.ProdutoException;
import com.example.petshop.repository.ProdutoRepository;
import com.example.petshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;
     PetRepository petRepository;
    public Produto salvar(Produto produto){
        if (produtoRepository.existsByNome(produto.getNome())){
            throw new ProdutoException("Produto já existe");
        }
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Produto produto, Long id){
        if (!produtoRepository.existsById(id)){
            throw new ProdutoException("Produto não existe");
        }
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarTodos(){
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            throw new ProdutoException("Não existe produtos");
        }

        return produtos;
    }

    public Produto buscarPorId(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(
                ()-> new ProdutoException("Produto não existe")
        );
        return produto;
    }

    public void deletar(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(
                ()-> new ProdutoException("Produto não existe")
        );

        produtoRepository.delete(produto);
    }


}
