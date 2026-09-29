package com.example.petshop.service;

import com.example.petshop.entity.Cliente;
import com.example.petshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        if (clienteRepository.existsByNome(cliente.getNome())){
            throw new
        }
    }
}
