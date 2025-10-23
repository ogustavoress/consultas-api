package com.github.ogustavoress.consultas_api.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ogustavoress.consultas_api.dto.consulta.ConsultaCreateRequest;
import com.github.ogustavoress.consultas_api.dto.consulta.ConsultaResponse;
import com.github.ogustavoress.consultas_api.dto.consulta.ConsultaUpdateRequest;
import com.github.ogustavoress.consultas_api.model.ConsultaStatus;
import com.github.ogustavoress.consultas_api.repository.ConsultaRepository;
import com.github.ogustavoress.consultas_api.service.ConsultaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;
    
    @Autowired
    private ConsultaRepository consultaRepository; 

    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaCreateRequest dto) {

        return ResponseEntity.status(201).body(new ConsultaResponse().toDto(consultaService.create(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> getById(@PathVariable Long id) {
        return consultaService.getById(id)
                .map(consulta -> new ConsultaResponse().toDto(consulta))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> getAll() {
        List<ConsultaResponse> consultas = consultaService.getAll()
                .stream()
                .map(consulta -> new ConsultaResponse().toDto(consulta))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("query")
    public ResponseEntity<List<ConsultaResponse>> getByStatus(ConsultaStatus status) {
        List<ConsultaResponse> consultas = consultaRepository.findByStatus(status)
                .stream()
                .map(consulta -> new ConsultaResponse().toDto(consulta))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(consultas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> update(@RequestBody ConsultaUpdateRequest dto, @PathVariable Long id) {
        return consultaService.update(dto, id)
                .map(consulta -> new ConsultaResponse().toDto(consulta))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (consultaService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
