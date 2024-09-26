package com.ln.microsservice.usuario.Persistance.Entities;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

import com.ln.microsservice.usuario.DTOs.EstudanteDTO;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Estudante extends Usuario {
    private String matricula;
    @Column(name = "cursos_matriculados_ids")
    private Collection<UUID> cursosMatriculados;
    @Column(name = "instituicao_ensino_id")
    private UUID instituicaoEnsino;
    @OneToMany(mappedBy = "estudante")
    private Collection<ProgressoTarefa> tarefasIniciadas;

    public Estudante(EstudanteDTO estudante) {
        super(null, estudante.nome(), estudante.dataNascimento(), estudante.numeroContato(), estudante.endereco(),
                estudante.email(), estudante.senha());
        this.matricula = estudante.matricula();
        this.instituicaoEnsino = estudante.instituicaoEnsino();
        this.cursosMatriculados = estudante.cursosMatriculados();
    }
}
