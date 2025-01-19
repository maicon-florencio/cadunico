package com.microsservice.cad.cadunico.rest;

import com.microsservice.cad.cadunico.service.dto.StacksTechDTO;
import com.microsservice.cad.cadunico.service.impl.StacksTechService;
import jakarta.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stacktech")
public class StackTechsController {

    Logger log = LoggerFactory.getLogger(StackTechsController.class);
    @Autowired
    private StacksTechService stacksTechService;

    @PostMapping
    public ResponseEntity<StacksTechDTO> criarStackTech(@RequestBody StacksTechDTO dto, ServletResponse servletResponse){
        log.info("Chamada servico cadastrar stack tech ");
        return new ResponseEntity<>(stacksTechService.create(dto), HttpStatus.CREATED);
    }
}
