package com.microsservice.cad.cadunico.rest;

import com.microsservice.cad.cadunico.service.ColaboradorServiceInt;
import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ColaboradorController {

    Logger log = LoggerFactory.getLogger(ColaboradorController.class);

    @Autowired
    private ColaboradorServiceInt clientService;

    @PostMapping
    public ResponseEntity<ColaboradorDTO> salvarCliente(@RequestBody ColaboradorDTO dto){
        log.info("Chamada servico cadastrar ");
        return ResponseEntity.ok(clientService.save(dto));
    }

    @PutMapping
    public ResponseEntity<ColaboradorDTO> atualizarCliente(@RequestBody ColaboradorDTO dto){
        log.info("Chamada servico atualizar ");
        return ResponseEntity.ok(clientService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> removerCliente(@PathVariable("id") Long id){
        log.info("Chamada servico remover id {}", id);
     clientService.deleteById(id);
    return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> buscaPorId(@PathVariable("id") Long id){
        log.info("Chamada busca por id ");
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ColaboradorDTO>> buscaAll(){
        log.info("Chamada  buscar todos ");
        return ResponseEntity.ok(clientService.findall());
    }
}
