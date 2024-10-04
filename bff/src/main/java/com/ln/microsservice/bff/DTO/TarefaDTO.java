package com.ln.microsservice.bff.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record TarefaDTO(
        UUID id,
        String titulo,
        String descricao,
        LocalDateTime prazo,
        Float valorEmPontos,
        UUID professorCriador,
        UUID materia) {
}
