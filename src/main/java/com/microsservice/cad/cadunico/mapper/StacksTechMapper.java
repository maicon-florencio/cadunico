package com.microsservice.cad.cadunico.mapper;

import com.microsservice.cad.cadunico.dominio.StacksTech;
import com.microsservice.cad.cadunico.dominio.key.StackTechEmId;
import com.microsservice.cad.cadunico.service.dto.StacksTechDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper( uses = {TechToolsMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface StacksTechMapper {


    StacksTechMapper INSTANCE = Mappers.getMapper(StacksTechMapper.class);

    @Mapping(target = "id", source = "dto", qualifiedByName = "getStackTechEmbId")
    StacksTech toEntity(StacksTechDTO dto);

    @InheritInverseConfiguration
    StacksTechDTO toDTO(StacksTech entity);

    @Named("getStackTechEmbId")
    default StackTechEmId toStacksTechEmId(StacksTechDTO dto){
        StackTechEmId stackTechEmId = new StackTechEmId();
        if(Objects.nonNull(dto.getStackTechId())) stackTechEmId.setStackTechId(dto.getStackTechId());
        if(Objects.nonNull(dto.getTechLaguageId())) stackTechEmId.setTechLaguageId(dto.getTechLaguageId());
        if(Objects.nonNull(dto.getSquadId())) stackTechEmId.setSquadId(dto.getSquadId());

        return stackTechEmId;
    }


}
