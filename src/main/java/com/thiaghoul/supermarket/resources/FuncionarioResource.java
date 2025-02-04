package com.thiaghoul.supermarket.resources;

import com.thiaghoul.supermarket.entities.Endereco;
import com.thiaghoul.supermarket.entities.Entrega;
import com.thiaghoul.supermarket.entities.Fornecedor;
import com.thiaghoul.supermarket.entities.Funcionario;
import com.thiaghoul.supermarket.services.EnderecoService;
import com.thiaghoul.supermarket.services.EntregaService;
import com.thiaghoul.supermarket.services.FornecedorService;
import com.thiaghoul.supermarket.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable String id) {
        Funcionario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Funcionario> insert(@RequestBody Funcionario obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable String id, @RequestBody Funcionario obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
