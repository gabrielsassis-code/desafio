package com.example.petshop.service;

import com.example.petshop.entity.Cliente;
import com.example.petshop.entity.Pet;
import com.example.petshop.exception.ClienteException;
import com.example.petshop.repository.ClienteRepository;
import com.example.petshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
     PetRepository petRepository;
    public Cliente salvar(Cliente cliente){
        if (clienteRepository.existsByNome(cliente.getNome())){
            throw new ClienteException("Cliente já existe");
        }
        return clienteRepository.save(cliente);
    }



    public Cliente atualizar(Cliente cliente, Long id){
        if (!clienteRepository.existsById(id)){
            throw new ClienteException("Cliente não existe");
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodos(){
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes.isEmpty()){
            throw new ClienteException("Não existe clientes");
        }

        return clientes;
    }

    public Cliente buscarPorId(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                ()-> new ClienteException("Cliente não existe")
        );
        return cliente;
    }

    public void deletar(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                ()-> new ClienteException("Cliente não existe")
        );

        clienteRepository.delete(cliente);
    }


}
