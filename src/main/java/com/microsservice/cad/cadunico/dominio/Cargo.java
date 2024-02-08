package com.microsservice.cad.cadunico.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
