package com.ln.microsservice.curso.DTO;

import java.util.UUID;

import com.ln.microsservice.curso.Persistance.Entities.Materia;

public record MateriaDTO(
        UUID id,
        String nome,
        String descricao) {

    public MateriaDTO(Materia materia) {
        this(materia.getId(), materia.getNome(), materia.getDescricao());
    }
}
