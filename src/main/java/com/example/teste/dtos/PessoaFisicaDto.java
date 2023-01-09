package com.example.teste.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisicaDto {

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    private String nome;

    private String dataNascimento;

}
