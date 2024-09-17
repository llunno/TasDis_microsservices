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
public class Estudante extends Usuario {
    private String matricula;
    @Column(name = "cursos_matriculados_ids")
    private Collection<UUID> cursosMatriculados;
    @Column(name = "tarefas_pendentes_ids")
    private Collection<UUID> tarefasPendentes;
    @Column(name = "instituicoes_ensino_ids")
    private Collection<UUID> instituicoesEnsino;
    @Column(name = "avaliacoes_recebidas_ids")
    private Collection<UUID> avaliacoesRecebidas;

    public Collection<UUID> obterTarefasPendentes() {
        return tarefasPendentes;
    }
}
