package com.ln.microsservice.bff.DTO;

import java.util.UUID;

public record CursoDTO(
        UUID id,
        String nome,
        String descricao,
        Float cargaHoraria,
        UUID instituicaoEnsino) {

}
