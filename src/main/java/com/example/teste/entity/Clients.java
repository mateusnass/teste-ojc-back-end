package com.example.teste.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
@Entity
@Table(name = "TB_CLIENTS")
public class Clients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENTS_ID")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Telefone telefone;

    @Column(name = "DATA_CRIACAO")
    private String dataCriacao;

    @Column(name = "DATA_ALTERACAO")
    private String dataAlteracao;


    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "pessoaFisica_id", referencedColumnName = "cpf")
    private PessoaFisica pessoaFisica;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "pessoaJuridica_id", referencedColumnName = "cnpj")
    private PessoaJuridica pessoaJuridica;

    @ManyToOne
    private User user;


}
