package com.ln.microsservice.curso.Persistance.Entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Collection;
import jakarta.persistence.JoinColumn;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String descricao;
    private Float cargaHoraria;
    @OneToMany(mappedBy = "curso", targetEntity = Materia.class)
    private Collection<Materia> materias;
    @Column(name = "instituicao_ensino_id")
    private UUID instituicaoEnsino;

    public void addMateria(Materia materia) {
        this.materias.add(materia);
    }
}
