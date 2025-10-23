package com.github.ogustavoress.consultas_api.dto.consulta;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import com.github.ogustavoress.consultas_api.model.Consulta;
import com.github.ogustavoress.consultas_api.model.ConsultaStatus;
import com.github.ogustavoress.consultas_api.model.Paciente;
import com.github.ogustavoress.consultas_api.model.Profissional;

public class ConsultaResponse {
    private Long id;
    private Paciente paciente;
    private Profissional profissional;
    private LocalDateTime dataConsulta;
    private ConsultaStatus status;
    private BigInteger quantidadeHoras;
    private BigDecimal valorConsulta;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ConsultaResponse toDto(Consulta consulta) {
        this.setId(consulta.getId());
        this.setPaciente(consulta.getPaciente());
        this.setProfissional(consulta.getProfissional());
        this.setDataConsulta(consulta.getData());
        this.setStatus(consulta.getStatus());
        this.setQuantidadeHoras(consulta.getQuantidadeHoras());
        this.setValorConsulta(consulta.getValorConsulta());
        this.setCreatedAt(consulta.getCreatedAt());
        this.setUpdatedAt(consulta.getUpdatedAt());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public ConsultaStatus getStatus() {
        return status;
    }

    public void setStatus(ConsultaStatus status) {
        this.status = status;
    }

    public BigInteger getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(BigInteger quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(BigDecimal valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}