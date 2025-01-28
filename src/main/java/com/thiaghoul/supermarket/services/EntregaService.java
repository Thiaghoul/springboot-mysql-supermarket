package com.thiaghoul.supermarket.services;

import com.thiaghoul.supermarket.entities.Endereco;
import com.thiaghoul.supermarket.entities.Entrega;
import com.thiaghoul.supermarket.repositories.EntregaRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega insert(Entrega obj){
        return entregaRepository.save(obj);
    }

    public List<Entrega> findAll(){
        return entregaRepository.findAll();
    }

    public Entrega findById(Long id){
        Optional<Entrega> obj = entregaRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        if(!entregaRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
            entregaRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Entrega update(Long id, Entrega obj){
        try{
            Entrega entidade = entregaRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return entregaRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Entrega entidade, Entrega obj){
        entidade.setEntregaData(obj.getEntregaData());

    }
}
