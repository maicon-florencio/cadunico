package com.microsservice.cad.cadunico.mapper;

import com.microsservice.cad.cadunico.dominio.Client;
import com.microsservice.cad.cadunico.service.ClientDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {})
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source ="entity.id" ,target = "id")
    @Mapping(source ="entity.nome" ,target = "nome")
    @Mapping(source ="entity.documento" ,target = "documento")
    @Mapping(source ="entity.status" ,target = "status")
    ClientDTO toDTO(Client entity);


    @InheritInverseConfiguration
    Client toEntity(ClientDTO dto);

    List<Client> toEnties (List<ClientDTO> dtos);

    List<ClientDTO> toDTOs (List<Client> entities);

}
