package com.microsservice.cad.cadunico.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO implements Serializable {
    private Long id;
    private String nomeCargo;
    private BigDecimal salario;
    private String lvCargo;
    private LocalDate dtInicioCargo;
    private LocalDate dtFimCargo;
    private Integer anosExperienciaArea;
    private LocalDateTime dtUpdated;
}
