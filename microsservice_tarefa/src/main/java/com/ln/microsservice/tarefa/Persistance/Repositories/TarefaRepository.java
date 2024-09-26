package com.ln.microsservice.tarefa.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import com.ln.microsservice.tarefa.Persistance.Entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

    Optional<Collection<Tarefa>> findAllByMateria(UUID materiaId);

    Optional<Collection<Tarefa>> findAllByProfessorCriador(UUID professorId);
}
