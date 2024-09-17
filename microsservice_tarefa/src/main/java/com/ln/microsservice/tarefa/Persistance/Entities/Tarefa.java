package com.ln.microsservice.tarefa.Persistance.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

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
    private Boolean concluida;
    private Integer percentualConclusao;

    public void concluir() {
        this.concluida = true;
        this.percentualConclusao = 100;
    }
}
