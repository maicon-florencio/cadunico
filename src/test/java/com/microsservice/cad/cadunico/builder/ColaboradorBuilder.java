package com.microsservice.cad.cadunico.builder;

import com.microsservice.cad.cadunico.dominio.Colaborador;
import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


public class ColaboradorBuilder {

    public static ColaboradorDTO retornaColaboradorDTOCPF(){
        return  ColaboradorDTO.builder()
                .id(1L)
                .nome("Juarez Rodrigues")
                .documento("257.049.330-92")
                .status(Boolean.TRUE)
                .cargo(CargoBuilder.createDto())
                .build();
    }
    public static ColaboradorDTO retornaColaboradorDTOCNPJ(){
        return  ColaboradorDTO.builder()
                .id(2L)
                .nome("MC Donalds")
                .documento("38.837.157/0001-49")
                .status(Boolean.TRUE)
                .cargo(CargoBuilder.listDTOs().get(1))
                .build();
    }

    public static List<ColaboradorDTO> retornaClientsDTO(){
        var cl1 = retornaColaboradorDTOCPF();
        var cl2 = retornaColaboradorDTOCNPJ();

        return Arrays.asList(cl1,cl2);
    }

    public static Colaborador retornaClientCPF(){
        return  Colaborador.builder()
                .id(1L)
                .nome("Maira Duarte")
                .documento("768.809.640-52")
                .status(Boolean.TRUE)
                .cargo(CargoBuilder.createEntity())
                .build();
    }

    public static Colaborador retornaClientCNPJ(){
        return  Colaborador.builder()
                .id(2L)
                .nome("Burguer KING")
                .documento("65.229.873/0001-16")
                .status(Boolean.TRUE)
                .cargo(CargoBuilder.entities().get(1))
                .build();
    }

    public static List<Colaborador> retornaClients(){
        var cl1 = retornaClientCPF();
        var cl2 = retornaClientCNPJ();

        return Arrays.asList(cl1,cl2);
    }




}
