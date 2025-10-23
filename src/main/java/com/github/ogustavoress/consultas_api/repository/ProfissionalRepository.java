package com.github.ogustavoress.consultas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.ogustavoress.consultas_api.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}
