package com.thiaghoul.supermarket.services;


import com.thiaghoul.supermarket.entities.Produto;
import com.thiaghoul.supermarket.repositories.ProdutoRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(Produto obj){
        return produtoRepository.save(obj);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        if(!produtoRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
            produtoRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Produto update(Long id, Produto obj){
        try{
            Produto entidade = produtoRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return produtoRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Produto entidade, Produto obj){
        entidade.setNome(obj.getNome());
        entidade.setDataValidade(obj.getDataValidade());
        entidade.setPreco(obj.getPreco());
        entidade.setQuantidade(obj.getQuantidade());

    }
}
