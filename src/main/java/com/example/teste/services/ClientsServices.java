package com.example.teste.services;


import com.example.teste.dtos.ClientsDto;
import com.example.teste.entity.Clients;
import com.example.teste.repository.ClientsRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientsServices {

    final
    ClientsRepository clientsRepository;

//    public ClientsServices(ClientsRepository clientsRepository) {
//        this.clientsRepository = clientsRepository;
//    }

    @Transactional
    public Clients save(Clients clients) {
        return clientsRepository.save(clients);
    }

//    public boolean existsByCpf(String cpf){
//        return clientsRepository.existsByCpf(cpf);
//    }
//
//    public boolean existsByCnpj(String cnpj){
//        return clientsRepository.existsByCnpj(cnpj);
//    }

//    public ResponseEntity createClients(ClientsDto clientsDto) {
//        Clients customerToSave = customerMapper.toModel(customerDto);
//        Optional<User> user = userRepository.findById(customerDto.getUserId());
//        if(verifyIfExistsByExample(customerToSave)){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("The person already exists.\n");
//        }else{
//            if(user.isEmpty()){
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The user not found.\n");
//            }
//            customerToSave.setUser(user.get());
//            customerRepository.save(customerToSave);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Person created successfully.\n");
//        }
//      }

}
