package com.inscricao.curso.controller;

import com.inscricao.curso.dto.request.InscricaoRequestDto;
import com.inscricao.curso.dto.response.InscricaoResponseDto;
import com.inscricao.curso.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping("/{id}")
    public ResponseEntity<InscricaoResponseDto> findById(@PathVariable(name ="id") Long id){
        return ResponseEntity.ok().body(inscricaoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<InscricaoResponseDto>> findAll(){

        return ResponseEntity.ok().body(inscricaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<InscricaoResponseDto> register(@RequestBody InscricaoRequestDto inscricaoRequestDto,
                                                          UriComponentsBuilder uriBuilder){
        InscricaoResponseDto inscricaoResponseDto = inscricaoService.register(inscricaoRequestDto);
        URI uri = uriBuilder.path("/inscricao/{id}").buildAndExpand(inscricaoResponseDto.getId()).toUri();
        return ResponseEntity.created(uri).body(inscricaoResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscricaoResponseDto> update(@RequestBody InscricaoRequestDto inscricaoDto,@PathVariable Long id){
            return ResponseEntity.ok().body(inscricaoService.update(id, inscricaoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(inscricaoService.delete(id));
    }

}
