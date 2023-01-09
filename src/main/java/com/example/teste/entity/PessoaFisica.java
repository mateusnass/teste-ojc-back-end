package com.example.teste.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "PESSOA_FISICA")
public class PessoaFisica {

    @Id
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, name = "NOME_PESSOA_FISICA")
    private String nome;


    @Column(nullable = false)
    private String dataNascimento;

    @JsonIgnore
    @OneToOne(mappedBy = "pessoaFisica")
    private Clients clients;
}
