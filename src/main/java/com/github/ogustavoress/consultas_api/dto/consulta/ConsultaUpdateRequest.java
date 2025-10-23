package com.github.ogustavoress.consultas_api.dto.consulta;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.github.ogustavoress.consultas_api.model.ConsultaStatus;

public class ConsultaUpdateRequest {
    private Long pacienteId;
    private Long profissionalId;
    private LocalDateTime data;
    private ConsultaStatus status;
    private BigInteger quantidadeHoras;

    public Long getPacienteId() {
        return pacienteId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
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
}
