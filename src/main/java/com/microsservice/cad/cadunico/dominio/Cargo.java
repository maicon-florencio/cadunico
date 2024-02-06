package com.microsservice.cad.cadunico.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity

public class Cargo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCargo;
    private BigDecimal salario;
    private String lvCargo;
    private LocalDate dtInicioCargo;
    private LocalDate dtFimCargo;
    private LocalDateTime dtUpdated;


}
