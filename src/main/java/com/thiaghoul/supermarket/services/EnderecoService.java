package com.thiaghoul.supermarket.services;

import com.thiaghoul.supermarket.entities.Endereco;
import com.thiaghoul.supermarket.repositories.EnderecoRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco insert(Endereco obj){
        return enderecoRepository.save(obj);
    }

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id){
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        if(!enderecoRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
            enderecoRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Endereco update(Long id, Endereco obj){
        try{
            Endereco entidade = enderecoRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return enderecoRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Endereco entidade, Endereco obj){
        entidade.setRua(obj.getRua());
        entidade.setNumero(obj.getNumero());
        entidade.setCep(obj.getCep());

    }
}
