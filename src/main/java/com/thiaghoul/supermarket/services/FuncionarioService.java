package com.thiaghoul.supermarket.services;

import com.thiaghoul.supermarket.entities.Funcionario;
import com.thiaghoul.supermarket.repositories.FuncionarioRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario insert(Funcionario obj){
        return funcionarioRepository.save(obj);
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(String id){
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(String id){
        if(!funcionarioRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
            funcionarioRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Funcionario update(String id, Funcionario obj){
        try{
            Funcionario entidade = funcionarioRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return funcionarioRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Funcionario entidade, Funcionario obj){
        entidade.setNome(obj.getNome());
        entidade.setSalario(obj.getSalario());
        entidade.setCargo(obj.getCargo());

    }
}
