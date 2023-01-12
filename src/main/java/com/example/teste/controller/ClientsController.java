package com.example.teste.controller;

import ch.qos.logback.core.net.server.Client;
import com.example.teste.dtos.ClientsDto;
import com.example.teste.dtos.UserDto;
import com.example.teste.entity.*;

import com.example.teste.repository.ClientsRepository;
import com.example.teste.repository.UserRepository;
import com.example.teste.services.ClientsServices;
import com.example.teste.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //Get
    @GetMapping
    public List<Clients> listar(){
        return clientsRepository.findAll();
    }



    //Get por Id Test
    @GetMapping("/{id}")
    public ResponseEntity<Object> getId(@PathVariable(name = "id") Long id){
        Optional<Clients> clientsOptional = clientsServices.findById(id);
        if (!clientsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientsOptional.get());
    }


    //Post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createPerson(@RequestBody ClientsDto clientsDto) {
        return clientsServices.createClients(clientsDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteId(@PathVariable(name = "id") Long id){
        Optional<Clients> clientsOptional = clientsServices.findById(id);
        if (!clientsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
        }
        clientsServices.delete(clientsOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> uptadeId(@PathVariable(name = "id") Long id,
                                           @RequestBody @Valid ClientsDto clientsDto){
        Optional<Clients> clientsOptional = clientsServices.findById(id);
        if (!clientsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
        }
        var clients = clientsOptional.get();
        clients.setDataAlteracao(clientsDto.getDataAlteracao());


//            PessoaFisica pessoaFisica = new PessoaFisica();
//            pessoaFisica.setNome(clientsDto.getPessoaFisica().getNome());
//            clients.setPessoaFisica(pessoaFisica);
//            clientsDto.getPessoaFisica();



//            PessoaJuridica pessoaJuridica = new PessoaJuridica();
//            pessoaJuridica.setSocialRazao(clientsDto.getPessoaJuridica().getRazaoSocial());
//            clients.setPessoaJuridica(pessoaJuridica);
//            clientsDto.getPessoaJuridica();

        Telefone telefone = new Telefone();
        telefone.setNumeroTelefone(clientsDto.getTelefone().getNumeroTelefone());
        clients.setTelefone(telefone);
        clientsDto.getTelefone();




        return ResponseEntity.status(HttpStatus.OK).body(clientsServices.save(clients));
    }





}
