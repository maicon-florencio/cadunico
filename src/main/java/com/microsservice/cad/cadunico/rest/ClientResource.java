package com.microsservice.cad.cadunico.rest;

import com.microsservice.cad.cadunico.service.ClientService;
import com.microsservice.cad.cadunico.service.dto.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientResource {

    Logger log = LoggerFactory.getLogger(ClientResource.class);

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> salvarCliente(@RequestBody ClientDTO dto){
        log.info("Chamada servico cadastrar ");
        return ResponseEntity.ok(clientService.save(dto));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> atualizarCliente(@RequestBody ClientDTO dto){
        log.info("Chamada servico atualizar ");
        return ResponseEntity.ok(clientService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> removerCliente(@PathVariable("id") Long id){
        log.info("Chamada servico remover id {}", id);
     clientService.deleteById(id);
    return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> buscaPorId(@PathVariable("id") Long id){
        log.info("Chamada busca por id ");
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ClientDTO>> buscaAll(){
        log.info("Chamada  buscar todos ");
        return ResponseEntity.ok(clientService.findall());
    }
}
