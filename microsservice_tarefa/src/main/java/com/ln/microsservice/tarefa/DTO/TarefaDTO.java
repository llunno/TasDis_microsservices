package com.ln.microsservice.tarefa.DTO;

import java.time.LocalDateTime;
import java.util.UUID;
import java.io.Serializable;
import com.ln.microsservice.tarefa.Persistance.Entities.Tarefa;

public record TarefaDTO(
        UUID id,
        String titulo,
        String descricao,
        LocalDateTime prazo,
        Float valorEmPontos,
        UUID materia,
        UUID professorCriador) implements Serializable {

    public TarefaDTO(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getValorEmPontos(),
                tarefa.getMateria(), tarefa.getProfessorCriador());
    }
}