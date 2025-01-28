package com.thiaghoul.supermarket.services;

import com.thiaghoul.supermarket.entities.Cliente;
import com.thiaghoul.supermarket.repositories.ClienteRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente obj){
        return clienteRepository.save(obj);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        if(!clienteRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
            clienteRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Cliente update(Long id, Cliente obj){
        try{
            Cliente entidade = clienteRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return clienteRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Cliente entidade, Cliente obj){
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());

    }
}
