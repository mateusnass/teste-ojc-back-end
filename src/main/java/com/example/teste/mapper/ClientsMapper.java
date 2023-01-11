package com.example.teste.mapper;

import com.example.teste.dtos.ClientsDto;
import com.example.teste.entity.Clients;
import com.example.teste.entity.PessoaFisica;
import com.example.teste.entity.PessoaJuridica;
import com.example.teste.entity.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public class ClientsMapper {
//    //Gera um mapeador para criar um PersonDto a partir de um Person, mapeando todos atributos.
//    ClientsMapper INSTANCE = Mappers.getMapper(ClientsMapper.class);
//
//    //Converte PersonDto para Person
//    Clients toModel(ClientsDto clientsDto);
//
//    //Converte Person para PersonDto
//    ClientsDto toDTO(Clients clients);

    public Clients map(ClientsDto clientsDto) {
        Clients clients = new Clients();
        Telefone telefone = new Telefone();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setCpf(clientsDto.getPessoaFisica().getCpf());
        pessoaFisica.setNome(clientsDto.getPessoaFisica().getNome());
        pessoaFisica.setDataNascimento(clientsDto.getPessoaFisica().getDataNascimento());
        pessoaJuridica.setCnpj(clientsDto.getPessoaJuridica().getCnpj());
        pessoaJuridica.setSocialRazao(clientsDto.getPessoaJuridica().getRazaoSocial());
        pessoaJuridica.setNomeFantasia(clientsDto.getPessoaJuridica().getNomeFantasia());
        clients.setTelefone(telefone);
        clients.setPessoaJuridica(pessoaJuridica);
        clientsDto.getTelefone();

        return clients;



    }
}
