package com.thiaghoul.supermarket.resources;

import com.thiaghoul.supermarket.entities.Categoria;
import com.thiaghoul.supermarket.entities.Pagamento;
import com.thiaghoul.supermarket.services.CategoriaService;
import com.thiaghoul.supermarket.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id){
        Pagamento obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Pagamento> insert(@RequestBody Pagamento obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
