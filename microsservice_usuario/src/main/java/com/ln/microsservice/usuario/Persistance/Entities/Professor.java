package com.ln.microsservice.usuario.Persistance.Entities;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Professor extends Usuario {
    private String matricula;
    @Column(name = "materias_lecionadas_ids")
    private Collection<UUID> materiasLecionadas;
    @Column(name = "instituicoes_ensino_id")
    private UUID instituicoesEnsino;
}
