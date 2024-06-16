package com.microsservice.cad.cadunico.rest;

import com.microsservice.cad.cadunico.service.dto.CargoDTO;
import com.microsservice.cad.cadunico.service.impl.CargoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Cargo", description = "Service Cargo")
@RequestMapping("/api/v1/cargos")
public class CargoController {

    private Logger log = LoggerFactory.getLogger(ColaboradorController.class);
    @Autowired
    private CargoService service;
    @Operation(
            summary = "Fetch all Cargos",
            description = "fetches all cargos entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping
    public ResponseEntity<List<CargoDTO>> findAll(){
        log.info("Chamada de todos os cargos");
        return ResponseEntity.ok(service.getAll());
    }
    @Operation(
            summary = "Fetch Cargos Id",
            description = "fetches by id cargos entitie data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> getById(@PathVariable("id") Long id){
        log.info("Buscar cargo por Id ");
        return ResponseEntity.ok(service.getById(id));
    }

}
