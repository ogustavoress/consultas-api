package com.github.ogustavoress.consultas_api.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.ogustavoress.consultas_api.dto.consulta.ConsultaCreateRequest;
import com.github.ogustavoress.consultas_api.dto.consulta.ConsultaUpdateRequest;
import com.github.ogustavoress.consultas_api.model.Consulta;
import com.github.ogustavoress.consultas_api.model.Paciente;
import com.github.ogustavoress.consultas_api.model.Profissional;
import com.github.ogustavoress.consultas_api.repository.ConsultaRepository;
import com.github.ogustavoress.consultas_api.repository.PacienteRepository;
import com.github.ogustavoress.consultas_api.repository.ProfissionalRepository;

@Service
public class ConsultaService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta create(ConsultaCreateRequest dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> {throw new RuntimeException("Paciente inexistente: ID" + dto.getPacienteId());
        });

        Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                .orElseThrow(() -> {throw new RuntimeException("Paciente inexistente: ID" + dto.getProfissionalId());
        });

        return consultaRepository.save(dto.toModel(paciente, profissional));       
        
    }

    public Optional<Consulta> getById(@PathVariable Long id) {
        return consultaRepository.findById(id);
    }
    
    public List<Consulta> getAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> update(ConsultaUpdateRequest dto, Long id) {
        return consultaRepository.findById(id).map(consulta -> {
            consulta.setData(dto.getData());
            consulta.setQuantidadeHoras(dto.getQuantidadeHoras());

            Paciente paciente = pacienteRepository.findById(dto.getPacienteId()).orElseThrow(() -> {
                throw new RuntimeException("Paciente inexistente: ID" + dto.getPacienteId());
            });

            Profissional profissional = profissionalRepository.findById(dto.getProfissionalId()).orElseThrow(() -> {
                throw new RuntimeException("Profissional inexistente: ID" + dto.getProfissionalId());
            });

            consulta.setPaciente(paciente);
            consulta.setProfissional(profissional);
            consulta.setValorConsulta(profissional.getValorHora().multiply(new BigDecimal(dto.getQuantidadeHoras())));
            consulta.setUpdatedAt(LocalDateTime.now());

            return consultaRepository.save(consulta);
        });
    }

    public boolean deleteById(Long id) {
        if (consultaRepository.findById(id).isPresent()) {
            consultaRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Consulta inexistente: ID" + id);
    }
}