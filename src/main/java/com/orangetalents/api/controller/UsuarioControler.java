package com.orangetalents.api.controller;

import com.orangetalents.api.error.ExceptionUsuarioNotFound;
import com.orangetalents.api.model.Endereco;
import com.orangetalents.api.model.Usuario;
import com.orangetalents.api.repository.EnderecoRepository;
import com.orangetalents.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        usuario.setEnderecos(Collections.emptyList());
        return usuarioRepository.save(usuario);
    }

    @PostMapping(path = {"/{idUsuario}/enderecos"})
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@RequestBody Endereco endereco, @PathVariable Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(!usuario.isPresent()){
            throw new ExceptionUsuarioNotFound("Usuário não localizado pelo ID ¯\\_(ツ)_/¯, use um ID válido!! ");
        }

        endereco.setUsuario(usuario.get());
        return enderecoRepository.save(endereco);
    }

}
