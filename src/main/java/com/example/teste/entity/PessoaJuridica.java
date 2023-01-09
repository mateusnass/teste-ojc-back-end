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
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica {

    @Id
    @Column(name = "CNPJ")
    private String cnpj;

    @Column(nullable = false,name = "RAZAO_SOCIAL")
    private String socialRazao;

    @Column(nullable = false,name = "NOME_FANTASIA")
    private String nomeFantasia;

    @JsonIgnore
    @OneToOne(mappedBy = "pessoaJuridica")
    private Clients clients;
}
