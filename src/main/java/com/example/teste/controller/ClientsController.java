package com.example.teste.controller;

import com.example.teste.dtos.ClientsDto;
import com.example.teste.dtos.UserDto;
import com.example.teste.entity.Clients;
import com.example.teste.entity.User;
import com.example.teste.repository.ClientsRepository;
import com.example.teste.repository.UserRepository;
import com.example.teste.services.ClientsServices;
import com.example.teste.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientsController {
    private ClientsServices clientsServices;


    public ClientsController(ClientsServices clientsServices) {
        this.clientsServices = clientsServices;
    }


    private ClientsRepository clientsRepository;

    @GetMapping
    public List<Clients> listar(){
        return clientsRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createPerson(@RequestBody ClientsDto clientsDto) {
        return clientsServices.createClients(clientsDto);
    }

//    @PostMapping
//    public ResponseEntity<Object> saveUser(@RequestBody @Valid ClientsDto clientsDto){
//
////        if (clientsServices.existsByCpf(clientsDto.getPessoaFisica().getCpf())){
////            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF já existente!");
////        }
////
////        if (clientsServices.existsByCnpj(clientsDto.getPessoaJuridica().getCnpj())){
////            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CNPJ já existente!");
////        }
//
//        var clients = new Clients();
//        BeanUtils.copyProperties(clientsDto, clients);
//        return ResponseEntity.status(HttpStatus.CREATED).body(clientsServices.save(clients));
//    }
}
