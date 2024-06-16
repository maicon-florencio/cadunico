package com.microsservice.cad.cadunico.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cargo  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCargo;
    private Double salario;
    private String maturidade;

    private LocalDate dtInicioCargo;

    private LocalDate dtFimCargo;
    private Integer anosExperienciaArea;

    private LocalDateTime dtUpdated;

}
