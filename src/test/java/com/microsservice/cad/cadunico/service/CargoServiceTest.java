package com.microsservice.cad.cadunico.service;

import com.microsservice.cad.cadunico.builder.CargoBuilder;
import com.microsservice.cad.cadunico.dominio.enumeration.MaturidadeCargoEnum;
import com.microsservice.cad.cadunico.repository.CargoRepository;
import com.microsservice.cad.cadunico.service.dto.CargoDTO;
import com.microsservice.cad.cadunico.service.impl.CargoService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class CargoServiceTest {

    @Autowired
    CargoService service;
    @Autowired
    CargoRepository repository;
    @BeforeEach
    void setUp(){
        var cargos = CargoBuilder.entities();
        repository.saveAll(cargos);
    }


    @Test
    void cargoSave_ok(){

    var newCargo = CargoBuilder.createDto();
        newCargo.setId(null);

        var result = service.save(newCargo);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getMaturidade().equals(MaturidadeCargoEnum.JUNIOR.name()));

        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void cargoSave_excaption(){
        CargoDTO request = null;
        try {
            service.save(request);
        }catch (RuntimeException e){
            return;
        }
        Assertions.fail(new RuntimeException("Objeto null"));
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }
    @Test
    void findAllCargo(){
        var listCargoFind = service.getAll();
        Assertions.assertNotNull(listCargoFind);
        Assertions.assertTrue(listCargoFind.size() >0);
    }


    @Test
    void updatedCargo_ok(){
        var currentCargo = service.getById(1L);
        currentCargo.setNomeCargo("Staff Principal Software Enginier");

        var resultUpdateCargo = service.update(currentCargo);

        Assertions.assertNotNull(resultUpdateCargo);
        Assertions.assertEquals(1L, resultUpdateCargo.getId());
        Assertions.assertEquals("Staff Principal Software Enginier", resultUpdateCargo.getNomeCargo());

        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void updatedCargo_exc_notfound(){
        CargoDTO dto = null;
        try {
           service.update(dto);
        }catch (RuntimeException e){
            return;
        }

        Assertions.fail(new RuntimeException("Objeto null"));
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void findById_Okay(){
        var result =  service.getById(1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("MIDDLE", result.getMaturidade());
    }
}
