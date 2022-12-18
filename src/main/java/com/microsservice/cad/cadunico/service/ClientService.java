package com.microsservice.cad.cadunico.service;

import com.microsservice.cad.cadunico.service.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    ClientDTO save(ClientDTO dto);
    ClientDTO update(ClientDTO dto);
    ClientDTO findById(Long id);
    List<ClientDTO> findall();

    void deleteById(Long id);
}
