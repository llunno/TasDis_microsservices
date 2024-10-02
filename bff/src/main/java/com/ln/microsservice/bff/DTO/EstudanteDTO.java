package com.ln.microsservice.bff.DTO;

import java.util.Collection;
import java.util.UUID;

public record EstudanteDTO(
    UUID id,
    String nome,
    String matricula,
    String email,
    String senha,
    String dataNascimento,
    Integer numeroContato,
    String instituicaoEnsino,
    Collection<UUID> cursosMatriculados
) {
}
