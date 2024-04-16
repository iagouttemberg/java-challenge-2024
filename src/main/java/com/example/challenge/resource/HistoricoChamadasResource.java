package com.example.challenge.resource;

import com.example.challenge.entity.HistoricoChamadas;
import com.example.challenge.repository.HistoricoChamadasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/historicochamadas")
public class HistoricoChamadasResource {
    @Autowired
    HistoricoChamadasRepository repository;

    @GetMapping
    public List<HistoricoChamadas> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public HistoricoChamadas findById(@PathVariable Long id) {
        return repository.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public HistoricoChamadas save(@RequestBody HistoricoChamadas h) {
        h.setId( null );
        return repository.save( h );
    }
}
