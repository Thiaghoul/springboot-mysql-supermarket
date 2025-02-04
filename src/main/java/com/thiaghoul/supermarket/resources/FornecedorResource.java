package com.thiaghoul.supermarket.resources;

import com.thiaghoul.supermarket.entities.Endereco;
import com.thiaghoul.supermarket.entities.Entrega;
import com.thiaghoul.supermarket.entities.Fornecedor;
import com.thiaghoul.supermarket.services.EnderecoService;
import com.thiaghoul.supermarket.services.EntregaService;
import com.thiaghoul.supermarket.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
        Fornecedor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
