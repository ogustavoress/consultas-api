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

import com.github.ogustavoress.consultas_api.dto.Paciente.PacienteCreateRequest;
import com.github.ogustavoress.consultas_api.dto.Paciente.PacienteResponse;
import com.github.ogustavoress.consultas_api.dto.Paciente.PacienteUpdateRequest;
import com.github.ogustavoress.consultas_api.service.PacienteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v0.2.2/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponse> create(@RequestBody PacienteCreateRequest dto) {

        return ResponseEntity.status(201).body(new PacienteResponse().toDto(pacienteService.create(dto)));
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> getById(@PathVariable Long id) {
        return pacienteService.getById(id)
                .map(paciente -> new PacienteResponse().toDto(paciente))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> getAll() {
        List<PacienteResponse> pacientes = pacienteService.getAll()
                .stream()
                .map(paciente -> new PacienteResponse().toDto(paciente))
                .collect(Collectors.toList());

        return ResponseEntity.ok(pacientes);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> update(@PathVariable Long id, @RequestBody PacienteUpdateRequest dto) {

        return pacienteService.update(id, dto)
                .map(updatePaciente -> new PacienteResponse().toDto(updatePaciente))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pacienteService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
