package com.example.challenge.resource;

import com.example.challenge.entity.Mensagem;
import com.example.challenge.repository.MensagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mensagem")
public class MensagemResource {
    @Autowired
    MensagemRepository repository;

    @GetMapping
    public List<Mensagem> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mensagem findById(@PathVariable Long id) {
        return repository.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Mensagem save(@RequestBody Mensagem m) {
        m.setId( null );
        return repository.save( m );
    }
}
