package com.ln.microsservice.usuario.Persistance.Entities;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Estudante extends Usuario {
    private String matricula;
    @Column(name = "cursos_matriculados_ids")
    private Collection<Integer> cursosMatriculados;
    @Column(name = "tarefas_pendentes_ids")
    private Collection<Integer> tarefasPendentes;
    @Column(name = "instituicoes_ensino_ids")
    private Collection<Integer> instituicoesEnsino;
    @Column(name = "avaliacoes_recebidas_ids")
    private Collection<Integer> avaliacoesRecebidas;

    public Collection<Integer> obterTarefasPendentes() {
        return tarefasPendentes;
    }
}
