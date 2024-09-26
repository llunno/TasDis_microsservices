package com.ln.microsservice.usuario.DTOs;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public record EstudanteDTO(
        String nome,
        LocalDate dataNascimento,
        Integer numeroContato,
        UUID endereco,
        String email,
        String senha,
        String matricula,
        UUID instituicaoEnsino,
        Collection<UUID> cursosMatriculados) {
}
