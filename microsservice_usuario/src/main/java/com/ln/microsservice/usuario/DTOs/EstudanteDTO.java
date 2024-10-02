package com.ln.microsservice.usuario.DTOs;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

import com.ln.microsservice.usuario.Persistance.Entities.Estudante;

public record EstudanteDTO(
    UUID id,
    String nome,
    LocalDate dataNascimento,
    Integer numeroContato,
    UUID endereco,
    String email,
    String senha,
    String matricula,
    UUID instituicaoEnsino,
    Collection<UUID> cursosMatriculados) {

    public EstudanteDTO(Estudante estudante) {
        this(estudante.getId(), estudante.getNome(), estudante.getDataNascimento(), estudante.getNumeroContato(), estudante.getEndereco(),
                estudante.getEmail(), estudante.getSenha(), estudante.getMatricula(), estudante.getInstituicaoEnsino(), estudante.getCursosMatriculados());
    }
}
