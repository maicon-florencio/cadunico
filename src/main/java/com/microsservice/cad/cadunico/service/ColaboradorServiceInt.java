package com.microsservice.cad.cadunico.service;

import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;

import java.util.List;

public interface ColaboradorServiceInt {

    ColaboradorDTO save(ColaboradorDTO dto);
    ColaboradorDTO update(ColaboradorDTO dto);
    ColaboradorDTO findById(Long id);
    List<ColaboradorDTO> findall();

    void deleteById(Long id);
}
