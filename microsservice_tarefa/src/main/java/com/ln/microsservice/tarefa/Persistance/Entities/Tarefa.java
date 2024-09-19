package com.ln.microsservice.tarefa.Persistance.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ln.microsservice.tarefa.DTO.TarefaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDateTime prazo;
    private Float valorEmPontos;
    @Column(name = "materia_id")
    private UUID materia;
    @Column(name = "professor_criador_id")
    private UUID professorCriador;

    public Tarefa(TarefaDTO tarefaDTO) {
        this.titulo = tarefaDTO.titulo();
        this.descricao = tarefaDTO.descricao();
        this.prazo = tarefaDTO.prazo();
        this.materia = tarefaDTO.materia();
        this.valorEmPontos = tarefaDTO.valorEmPontos();
    }
}
