package com.ln.microsservice.tarefa.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.ln.microsservice.tarefa.Persistance.Entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

}
