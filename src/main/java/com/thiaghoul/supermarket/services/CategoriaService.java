package com.thiaghoul.supermarket.services;

import com.thiaghoul.supermarket.entities.Categoria;
import com.thiaghoul.supermarket.repositories.CategoriaRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria insert(Categoria obj){
        return categoriaRepository.save(obj);
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        if(!categoriaRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
           categoriaRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Categoria update(Long id, Categoria obj){
        try{
            Categoria entidade = categoriaRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return categoriaRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Categoria entidade, Categoria obj){
        entidade.setNome(obj.getNome());

    }
}
