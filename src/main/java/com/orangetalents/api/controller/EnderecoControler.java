package com.orangetalents.api.controller;

import com.orangetalents.api.model.Endereco;
import com.orangetalents.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/{id}/endereco"})
public class EnderecoControler {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adiciona(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
