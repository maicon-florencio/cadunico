package com.microsservice.cad.cadunico.service;

import com.microsservice.cad.cadunico.builder.CargoBuilder;
import com.microsservice.cad.cadunico.repository.CargoRepository;
import com.microsservice.cad.cadunico.service.impl.CargoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void findById_Okay(){
        var result =  service.getById(1L);
        Assertions.assertNotNull(result);
    }
}
