package com.microsservice.cad.cadunico.repository;

import com.microsservice.cad.cadunico.dominio.StacksTech;
import com.microsservice.cad.cadunico.dominio.key.StackTechEmId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StacksTechRepository extends JpaRepository<StacksTech, StackTechEmId> {
}
