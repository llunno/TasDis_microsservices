package com.ln.microsservice.curso.DTO;

import java.util.UUID;

import com.ln.microsservice.curso.Persistance.Entities.Curso;

public record CursoDTO(
    UUID id,
    String nome,
    String descricao,
    Float cargaHoraria,
    UUID instituicaoEnsino
) {
    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getName(), curso.getDescricao(), curso.getCargaHoraria(), curso.getInstituicaoEnsino());
    }
}
