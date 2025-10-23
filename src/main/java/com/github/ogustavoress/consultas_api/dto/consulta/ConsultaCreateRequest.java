package com.github.ogustavoress.consultas_api.dto.consulta;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import com.github.ogustavoress.consultas_api.model.Consulta;
import com.github.ogustavoress.consultas_api.model.ConsultaStatus;
import com.github.ogustavoress.consultas_api.model.Paciente;
import com.github.ogustavoress.consultas_api.model.Profissional;

public class ConsultaCreateRequest {
    private Long pacienteId;
    private Long profissionalId;

    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime data;
    private BigInteger quantidadeHoras;
    private BigDecimal valorConsulta;

    public Consulta toModel(Paciente paciente, Profissional profissional){
        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setProfissional(profissional);
        consulta.setData(data);
        consulta.setStatus(ConsultaStatus.AGENDADA);
        consulta.setQuantidadeHoras(this.getQuantidadeHoras());
        consulta.setValorConsulta(profissional.getValorHora().multiply(new BigDecimal(quantidadeHoras)));
        return consulta;
    }

    public Long getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }
    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
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
}
