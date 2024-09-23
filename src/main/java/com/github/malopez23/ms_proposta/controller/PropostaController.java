//Marcelo Lopez Rodriguez Filho
//RM: 94592

package com.github.malopez23.ms_proposta.controller;

import com.github.malopez23.ms_proposta.dto.PropostaDTO;
import com.github.malopez23.ms_proposta.service.PropostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaService service;

   @GetMapping
   public ResponseEntity<Page<PropostaDTO>> findAll(@PageableDefault(size = 10)Pageable pageable) {
       Page<PropostaDTO> dto = service.findAll(pageable);
       return ResponseEntity.ok(dto);
   }


    @GetMapping(value = "/{id}")
    public ResponseEntity<PropostaDTO> findById(@PathVariable Long id) {
        PropostaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PropostaDTO> insert(@RequestBody @Valid PropostaDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto)
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropostaDTO> update(@PathVariable Long id,
                                              @RequestBody @Valid PropostaDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
