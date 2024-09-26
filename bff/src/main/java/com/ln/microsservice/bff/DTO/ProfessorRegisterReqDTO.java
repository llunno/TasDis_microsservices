package com.ln.microsservice.bff.DTO;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public record ProfessorRegisterReqDTO(
        String nome,
        LocalDate dataNascimento,
        Integer numeroContato,
        UUID endereco,
        String email,
        String senha,
        String matricula,
        Collection<UUID> materiasLecionadas,
        UUID instituicaoEnsino){}
