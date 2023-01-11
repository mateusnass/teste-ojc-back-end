package com.example.teste.services;


import com.example.teste.dtos.ClientsDto;
import com.example.teste.entity.*;
import com.example.teste.mapper.ClientsMapper;
import com.example.teste.repository.ClientsRepository;
import com.example.teste.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientsServices {

    private ClientsRepository clientsRepository;
    private UserRepository userRepository;

//    public ClientsServices(ClientsRepository clientsRepository) {
//        this.clientsRepository = clientsRepository;
//    }

    @Transactional
    public Clients save(Clients clients) {
        return clientsRepository.save(clients);
    }

    public ResponseEntity createClients(ClientsDto clientsDto) {
        Clients clientsToSave = map(clientsDto);
//        Optional<User> user = userRepository.findById(clientsDto.getUserId());
        if(verifyIfExistsByExample(clientsToSave)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The person already exists.\n");
        }

            clientsRepository.save(clientsToSave);
            return ResponseEntity.status(HttpStatus.CREATED).body("Person created successfully.\n");
        }

    private boolean verifyIfExistsByExample(Clients clients) {
        Example<Clients> example = Example.of(clients);
        return clientsRepository.exists(example);
    }
    private Clients map(ClientsDto clientsDto) {
        Clients clients = new Clients();
        Telefone telefone = new Telefone();


        if(Optional.ofNullable(clientsDto.getPessoaFisica()).isPresent()) {
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setCpf(clientsDto.getPessoaFisica().getCpf());
            pessoaFisica.setNome(clientsDto.getPessoaFisica().getNome());
            pessoaFisica.setDataNascimento(clientsDto.getPessoaFisica().getDataNascimento());
            clients.setPessoaFisica(pessoaFisica);
        }

        if(Optional.ofNullable(clientsDto.getPessoaJuridica()).isPresent()) {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setCnpj(clientsDto.getPessoaJuridica().getCnpj());
            pessoaJuridica.setSocialRazao(clientsDto.getPessoaJuridica().getRazaoSocial());
            pessoaJuridica.setNomeFantasia(clientsDto.getPessoaJuridica().getNomeFantasia());
            clients.setPessoaJuridica(pessoaJuridica);
        }

        telefone.setNumeroTelefone(clientsDto.getTelefone().getNumeroTelefone());
        clients.setTelefone(telefone);
        clientsDto.getTelefone();

        return clients;


    }
}





