package com.thiaghoul.supermarket.services;

import com.thiaghoul.supermarket.entities.Pagamento;
import com.thiaghoul.supermarket.repositories.PagamentoRepository;
import com.thiaghoul.supermarket.services.exceptions.DatabaseException;
import com.thiaghoul.supermarket.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento insert(Pagamento obj){
        return pagamentoRepository.save(obj);
    }

    public List<Pagamento> findAll(){
        return pagamentoRepository.findAll();
    }

    public Pagamento findById(Long id){
        Optional<Pagamento> obj = pagamentoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        if(!pagamentoRepository.existsById(id)){
            throw new ResourceNotFoundException(id);

        }
        try{
            pagamentoRepository.deleteById(id);

        }catch(DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));

        }
    }

    public Pagamento update(Long id, Pagamento obj){
        try{
            Pagamento entidade = pagamentoRepository.getReferenceById(id);
            updateDados(entidade, obj);
            return pagamentoRepository.save(entidade);

        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);

        }
    }

    public void updateDados(Pagamento entidade, Pagamento obj){
        entidade.setPagamentoMomento(obj.getPagamentoMomento());

    }
}
