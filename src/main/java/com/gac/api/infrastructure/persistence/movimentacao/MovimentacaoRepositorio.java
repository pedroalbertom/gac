package com.gac.api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimentacaoRepositorio extends JpaRepository<MovimentacaoEntity, Long> {
    List<MovimentacaoEntity> findByMatriculaProfessor(String matriculaProfessor);
}