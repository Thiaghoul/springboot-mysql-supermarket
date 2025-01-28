package com.thiaghoul.supermarket.services;

import com.thiaghoul.supermarket.entities.Fornecedor;
import com.thiaghoul.supermarket.repositories.FornecedorRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor insert(Fornecedor obj){
        return fornecedorRepository.save(obj);
    }

    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    public Fornecedor findById(Long id){
        Optional<Fornecedor> obj = fornecedorRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        if(!fornecedorRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
            fornecedorRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Fornecedor update(Long id, Fornecedor obj){
        try{
            Fornecedor entidade = fornecedorRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return fornecedorRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Fornecedor entidade, Fornecedor obj){
        entidade.setNome(obj.getNome());
        entidade.setTelefone(obj.getTelefone());

    }
}
