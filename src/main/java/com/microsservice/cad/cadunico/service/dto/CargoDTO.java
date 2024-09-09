package com.microsservice.cad.cadunico.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO implements Serializable {
    private Long id;
    private String nomeCargo;
    private Double salario;
    private String maturidade;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dtInicioCargo;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dtFimCargo;
    private Integer anosExperienciaArea;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dtUpdated;
}
