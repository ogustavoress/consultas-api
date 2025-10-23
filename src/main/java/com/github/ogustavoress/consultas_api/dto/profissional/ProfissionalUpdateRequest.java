package com.github.ogustavoress.consultas_api.dto.profissional;

import java.math.BigDecimal;

import com.github.ogustavoress.consultas_api.model.Profissional;

public class ProfissionalUpdateRequest {
    private String nome;
    private String especialidade;
    private BigDecimal valorHora;

    public Profissional toModel(Profissional profissional) {
        profissional.setNome(this.nome);
        profissional.setEspecialidade(this.especialidade);
        profissional.setValorHora(this.valorHora);
        return profissional;
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
}
