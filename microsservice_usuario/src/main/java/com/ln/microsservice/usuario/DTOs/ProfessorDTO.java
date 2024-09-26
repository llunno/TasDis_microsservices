package com.ln.microsservice.usuario.DTOs;

import java.util.Collection;
import java.time.LocalDate;
import java.util.UUID;

public record ProfessorDTO(
        String nome,
        LocalDate dataNascimento,
        Integer numeroContato,
        UUID endereco,
        String email,
        String senha,
        String matricula,
        Collection<UUID> materiasLecionadas,
        UUID instituicaoEnsino) {
}
