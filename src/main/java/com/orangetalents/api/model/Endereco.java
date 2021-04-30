package com.orangetalents.api.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "endereco_seq", initialValue = 1, allocationSize = 1)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idaddress;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private Long numero;

    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Long cep;

    private Usuario usuario;
}
