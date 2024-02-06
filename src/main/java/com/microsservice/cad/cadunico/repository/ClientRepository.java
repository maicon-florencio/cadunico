package com.microsservice.cad.cadunico.repository;

import com.microsservice.cad.cadunico.dominio.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

     Boolean getClientByDocumento(String doc);

}
