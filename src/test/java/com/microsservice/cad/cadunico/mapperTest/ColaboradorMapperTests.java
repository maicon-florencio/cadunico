package com.microsservice.cad.cadunico.mapperTest;

import com.microsservice.cad.cadunico.builder.ColaboradorBuilder;
import com.microsservice.cad.cadunico.mapper.ColaboradorMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ColaboradorMapperTests {
    @Autowired
    private ColaboradorBuilder cBuilder;

    @Test
    public void covertEntityToDTO(){

        var entity = cBuilder.retornaClientCPF();

        var dto = ColaboradorMapper.INSTANCE.toDTO(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(dto.getNome(),entity.getNome());
        Assertions.assertEquals(dto.getDocumento(),entity.getDocumento());

    }
    @Test
    public void covertDTOToEntity(){

        var dto = cBuilder.retornaColaboradorDTOCPF();

        var entity = ColaboradorMapper.INSTANCE.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(entity.getNome(),dto.getNome());
        Assertions.assertEquals(entity.getDocumento(),dto.getDocumento());

    }

    @Test
    public void convertEntitiesToDTOs(){
        var entities = cBuilder.retornaClients();
        var dtos = ColaboradorMapper.INSTANCE.toDTOs(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(dtos.size(),entities.size());
        Assertions.assertEquals(dtos.get(1).getNome(),entities.get(1).getNome());
        Assertions.assertEquals(dtos.get(1).getDocumento(),entities.get(1).getDocumento());

    }
    @Test
    public void convertDTOsToEntities(){
        var dtos = cBuilder.retornaClientsDTO();
        var entities = ColaboradorMapper.INSTANCE.toEnties(dtos);

        Assertions.assertNotNull(entities);
        Assertions.assertEquals(entities.size(),dtos.size());
        Assertions.assertEquals(entities.get(1).getNome(),dtos.get(1).getNome());
        Assertions.assertEquals(entities.get(1).getDocumento(),dtos.get(1).getDocumento());

    }

}
