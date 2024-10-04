package com.ln.microsservice.tarefa.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;
import com.ln.microsservice.tarefa.Persistance.Entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

    @Query("SELECT t FROM Tarefa t WHERE t.materia = :materiaId")
    Collection<Tarefa> findAllByMateria(UUID materiaId);

    @Query("SELECT t FROM Tarefa t WHERE t.professorCriador = :professorId")
    Collection<Tarefa> findAllByProfessorCriador(UUID professorId);
}
