package com.microsservice.cad.cadunico.service.impl;

import com.microsservice.cad.cadunico.mapper.StacksTechMapper;
import com.microsservice.cad.cadunico.repository.StacksTechRepository;
import com.microsservice.cad.cadunico.service.dto.StacksTechDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StacksTechService {
    @Autowired
    private StacksTechRepository repository;

    public StacksTechDTO create(StacksTechDTO stacksTechDTO) {
        var stacksTech = StacksTechMapper.INSTANCE.toEntity(stacksTechDTO);
        return StacksTechMapper.INSTANCE.toDTO(repository.save(stacksTech));
    }
}
