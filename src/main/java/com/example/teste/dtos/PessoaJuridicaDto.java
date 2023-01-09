package com.example.teste.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaJuridicaDto {

    @NotNull
    private String cnpj;

    @NotNull
    private String razãoSocial;

    @NotNull
    private String nomeFantasia;

}
