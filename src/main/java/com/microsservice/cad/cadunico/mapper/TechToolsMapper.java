package com.microsservice.cad.cadunico.mapper;

import com.microsservice.cad.cadunico.dominio.TechTools;
import com.microsservice.cad.cadunico.dominio.key.TechToolsEmId;
import com.microsservice.cad.cadunico.service.dto.TechToolsDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring",  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface TechToolsMapper {

    TechToolsMapper INSTANCE = Mappers.getMapper(TechToolsMapper.class);


    @Mapping(target = "id", source = "dto", qualifiedByName = "getTechToolsEmbId")
    TechTools toEntity(TechToolsDTO dto);

    @InheritInverseConfiguration
    TechToolsDTO toDTO(TechTools entity);

    List<TechTools> toEntities(List<TechToolsDTO> dtos);

    List<TechToolsDTO> toDTOs(List<TechTools> entities);


    @Named("getTechToolsEmbId")
    default TechToolsEmId toTechToolsEmbId(TechToolsDTO dto){
        TechToolsEmId techToolsEmId = new TechToolsEmId();
        if(Objects.nonNull(dto.getTechToolsId())) techToolsEmId.setTechToolsId(dto.getTechToolsId());
        if(Objects.nonNull(dto.getStacksTechId())) techToolsEmId.setStacksTechId(dto.getStacksTechId());
        return techToolsEmId;
    }
}
