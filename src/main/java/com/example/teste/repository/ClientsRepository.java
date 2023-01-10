package com.example.teste.repository;

import com.example.teste.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, UUID> {
//    boolean existsByCpf(String cpf);
//
//    boolean existsByCnpj(String cnpj);

}
