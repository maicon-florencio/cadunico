package com.microsservice.cad.cadunico.rest;

import com.microsservice.cad.cadunico.service.dto.ColaboradorDTO;
import com.microsservice.cad.cadunico.service.impl.ColaboradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/colaboradores")
public class ColaboradorController {

    Logger log = LoggerFactory.getLogger(ColaboradorController.class);

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    public ResponseEntity<ColaboradorDTO> salvarCliente(@RequestBody ColaboradorDTO dto){
        log.info("Chamada servico cadastrar ");
        return ResponseEntity.ok(colaboradorService.save(dto));
    }

    @PutMapping
    public ResponseEntity<ColaboradorDTO> atualizarCliente(@RequestBody ColaboradorDTO dto){
        log.info("Chamada servico atualizar ");
        return ResponseEntity.ok(colaboradorService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> removerCliente(@PathVariable("id") Long id){
        log.info("Chamada servico remover id {}", id);
     colaboradorService.deleteById(id);
    return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> buscaPorId(@PathVariable("id") Long id){
        log.info("Chamada busca por id ");
        return ResponseEntity.ok(colaboradorService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ColaboradorDTO>> buscaAll(){
        log.info("Chamada  buscar todos ");
        return ResponseEntity.ok(colaboradorService.findall());
    }
    @PatchMapping()
    public ResponseEntity<ColaboradorDTO> improveAmountSalary(@RequestBody String document){
        log.info("Chamada  improment salary ");
        return ResponseEntity.ok(colaboradorService.growUpAmountSalary(document));
    }
}
