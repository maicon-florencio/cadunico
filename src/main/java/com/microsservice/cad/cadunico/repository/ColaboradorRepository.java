package com.microsservice.cad.cadunico.repository;

import com.microsservice.cad.cadunico.dominio.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador,Long> {

     Boolean getClientByDocumento(String doc);

}
