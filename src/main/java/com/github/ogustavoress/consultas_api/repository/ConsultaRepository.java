package com.github.ogustavoress.consultas_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.ogustavoress.consultas_api.model.Consulta;
import com.github.ogustavoress.consultas_api.model.ConsultaStatus;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // select c.* from consulta c where c.status = '?'
    public List<Consulta> findByStatus(ConsultaStatus status);
}
