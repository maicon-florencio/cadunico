package com.microsservice.cad.cadunico.service;

import com.microsservice.cad.cadunico.builder.ColaboradorBuilder;
import com.microsservice.cad.cadunico.repository.ColaboradorRepository;
import com.microsservice.cad.cadunico.service.impl.ColaboradorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ColabordorServiceTest {
    @Autowired
    private ColaboradorBuilder clientBuilder;
    @Autowired
    private ColaboradorService service;
    @MockBean
    private ColaboradorRepository repository;


    @Test
    void salvaColaborador_okay(){

    }
}
