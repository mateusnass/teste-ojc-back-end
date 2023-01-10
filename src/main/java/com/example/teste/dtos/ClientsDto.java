package com.example.teste.dtos;

import com.example.teste.entity.PessoaJuridica;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClientsDto {

    private TelefoneDto telefone;

    private String dataCriacao;

    private String dataAlteracao;

    private PessoaFisicaDto pessoaFisica;


    private PessoaJuridicaDto pessoaJuridica;
    ;

}
