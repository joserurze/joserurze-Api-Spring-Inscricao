package com.inscricao.curso.repository;

import com.inscricao.curso.entity.Inscricao;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
