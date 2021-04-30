package com.orangetalents.api.controller;

import com.orangetalents.api.model.Endereco;
import com.orangetalents.api.model.Usuario;
import com.orangetalents.api.repository.EnderecoRepository;
import com.orangetalents.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControler implements Serializable {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @PostMapping(path = {"/{idUsuario}/endereco"})
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@RequestBody Endereco endereco) {

        return enderecoRepository.save(endereco);
    }

}
