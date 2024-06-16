package com.microsservice.cad.cadunico.service.impl;

import com.microsservice.cad.cadunico.exception.BusinessException;
import com.microsservice.cad.cadunico.mapper.CargoMapper;
import com.microsservice.cad.cadunico.repository.CargoRepository;
import com.microsservice.cad.cadunico.service.dto.CargoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public CargoDTO save(CargoDTO dto) {
        if(Objects.isNull(dto)) throw  new RuntimeException("Objeto null");
         var entityAtual =   cargoRepository.save(CargoMapper.INSTANCE.toEntity(dto));
        return CargoMapper.INSTANCE.toDTO(entityAtual);
    }

    public CargoDTO update(CargoDTO dto) {
        if(Objects.isNull(dto)) throw  new RuntimeException("Objeto null");
        var entityAtual = cargoRepository.save(CargoMapper.INSTANCE.toEntity(dto));
        return CargoMapper.INSTANCE.toDTO(entityAtual);
    }

    public List<CargoDTO> getAll() {
        var resultFind = cargoRepository.findAll();
        if (resultFind.isEmpty()) throw new BusinessException("Lista vazia.");
        return CargoMapper.INSTANCE.toDTOs(resultFind);
    }

    public CargoDTO getById(Long id) {
        var resultFind = cargoRepository.findById(id);
        var found = resultFind.orElseThrow(()-> new BusinessException("Id não encontrado."));
        return CargoMapper.INSTANCE.toDTO(found);
    }


}
