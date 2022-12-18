package com.microsservice.cad.cadunico.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    private Long id;
    private String nome;
    private String documento;
    private Boolean status;

}
