package com.ln.microsservice.usuario.Persistance.Entities;

import java.util.Collection;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Professor extends Usuario {
    private String matricula;
    @Column(name = "materias_lecionadas_ids")
    private Collection<Integer> materiasLecionadas;
    @Column(name = "tarefas_lancadas_ids")
    private Collection<Integer> tarefasLancadas;
    @Column(name = "instituicoes_ensino_ids")
    private Collection<Integer> instituicoesEnsino;
    @Column(name = "avaliacoes_lancadas_ids")
    private Collection<Integer> avaliacoesLancadas;
}
