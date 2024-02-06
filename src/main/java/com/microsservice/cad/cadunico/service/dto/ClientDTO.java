package com.microsservice.cad.cadunico.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO  implements Serializable {

    private Long id;
    private String nome;
    private String documento;
    private Boolean status;

    private String cargo;
    private Integer anosExpCargo;
    private BigDecimal salario;

}
