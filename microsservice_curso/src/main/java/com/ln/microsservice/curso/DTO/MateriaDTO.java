package com.ln.microsservice.curso.DTO;

import java.util.Collection;
import java.util.UUID;

import com.ln.microsservice.curso.Persistance.Entities.Materia;

public record MateriaDTO(
        UUID id,
        String nome,
        String descricao,
        Collection<UUID> cursosId) {

    public MateriaDTO(Materia materia) {
        this(materia.getId(), materia.getNome(), materia.getDescricao(),
                materia.getCursos().stream().map(curso -> curso.getId()).toList());
    }
}
