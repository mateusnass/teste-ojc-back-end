package com.example.teste.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotBlank
    private String login;

    @NotBlank
    @Size(max = 20)
    private String password;

}
