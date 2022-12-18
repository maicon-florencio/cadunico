package com.microsservice.cad.cadunico.builder;

import com.microsservice.cad.cadunico.dominio.Client;
import com.microsservice.cad.cadunico.service.dto.ClientDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClientBuilder {

    public ClientDTO retornaClientDTOCPF(){
        return  ClientDTO.builder()
                .nome("Juarez Rodrigues")
                .documento("257.049.330-92")
                .status(Boolean.TRUE)
                .build();
    }
    public ClientDTO retornaClientDTOCNPJ(){
        return  ClientDTO.builder()

                .nome("MC Donalds")
                .documento("38.837.157/0001-49")
                .status(Boolean.TRUE)
                .build();
    }

    public List<ClientDTO> retornaClientsDTO(){
        var cl1 = retornaClientDTOCPF();
        var cl2 = retornaClientDTOCNPJ();

        return Arrays.asList(cl1,cl1);
    }

    public Client retornaClientCPF(){
        return  Client.builder()
                .nome("Maira Duarte")
                .documento("768.809.640-52")
                .status(Boolean.TRUE)
                .build();
    }

    public Client retornaClientCNPJ(){
        return  Client.builder()
                .nome("Burguer KING")
                .documento("65.229.873/0001-16")
                .status(Boolean.TRUE)
                .build();
    }

    public List<Client> retornaClients(){
        var cl1 = retornaClientCPF();
        var cl2 = retornaClientCNPJ();

        return Arrays.asList(cl1,cl1);
    }




}
