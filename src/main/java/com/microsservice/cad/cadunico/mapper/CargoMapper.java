package com.microsservice.cad.cadunico.mapper;

import com.microsservice.cad.cadunico.dominio.Cargo;
import com.microsservice.cad.cadunico.service.dto.CargoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface CargoMapper {

    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    CargoDTO toDTO(Cargo entity);
    @InheritInverseConfiguration
    Cargo toEntity(CargoDTO dto);

    List<CargoDTO> toDTOs(List<Cargo> entites);
    List<Cargo> toEntities(List<CargoDTO> DTOs);
}
