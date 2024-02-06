package com.microsservice.cad.cadunico.mapper;

import com.microsservice.cad.cadunico.dominio.Colaborador;
import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {})
public interface ColaboradorMapper {

    ColaboradorMapper INSTANCE = Mappers.getMapper(ColaboradorMapper.class);

    @Mapping(source ="entity.id" ,target = "id")
    @Mapping(source ="entity.nome" ,target = "nome")
    @Mapping(source ="entity.documento" ,target = "documento")
    @Mapping(source ="entity.status" ,target = "status")
    ColaboradorDTO toDTO(Colaborador entity);


    @InheritInverseConfiguration
    Colaborador toEntity(ColaboradorDTO dto);

    List<Colaborador> toEnties (List<ColaboradorDTO> dtos);

    List<ColaboradorDTO> toDTOs (List<Colaborador> entities);

}
