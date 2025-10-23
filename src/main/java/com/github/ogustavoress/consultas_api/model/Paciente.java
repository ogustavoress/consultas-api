package com.github.ogustavoress.consultas_api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Paciente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefoneCompleto;
    private LocalDate dataNascimento;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Profissional getProfissional() {
        return profissional;
    }
    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefoneCompleto() {
        return telefoneCompleto;
    }
    public void setTelefoneCompleto(String telefoneCompleto) {
        this.telefoneCompleto = telefoneCompleto;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

