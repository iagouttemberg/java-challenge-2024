package com.example.challenge.resource;

import com.example.challenge.entity.Cliente;
import com.example.challenge.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
    @Autowired
    ClienteRepository repository;

    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Cliente findById(@PathVariable Long id) {
        return repository.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Cliente save(@RequestBody Cliente c) {
        c.setId( null );
        return repository.save( c );
    }
}
