package com.github.ogustavoress.consultas_api.model;

public enum ConsultaStatus {
    AGENDADA("Consulta Agendada"),
    REALIZADA("Consulta Realizada"),
    CANCELADA("Consulta Cancelada");

    private String mensagem;

    //get e set de mensagem
    private ConsultaStatus(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
