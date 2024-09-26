package com.ln.microsservice.bff.DTO;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public record EstudanteRegisterReqDTO(
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
