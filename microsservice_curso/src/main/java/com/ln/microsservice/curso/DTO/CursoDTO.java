package com.ln.microsservice.curso.DTO;

import java.util.UUID;

public record CursoDTO(
    UUID id,
    String nome,
    String descricao,
    Float cargaHoraria,
    UUID instituicaoEnsino
) {
}
