package com.github.ogustavoress.consultas_api.dto.profissional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.ogustavoress.consultas_api.model.Profissional;

public class ProfissionalResponse {
    private String nome;
    private String especialidade;
    private BigDecimal valorHora;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProfissionalResponse toDto(Profissional updateProfissional){
        ProfissionalResponse response = new ProfissionalResponse();
        response.setNome(updateProfissional.getNome());
        response.setEspecialidade(updateProfissional.getEspecialidade());
        response.setValorHora(updateProfissional.getValorHora());
        response.setCreatedAt(updateProfissional.getCreatedAt());
        response.setUpdatedAt(updateProfissional.getUpdatedAt());
        return response;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public BigDecimal getValorHora() {
        return valorHora;
    }
    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
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
