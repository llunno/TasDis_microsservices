package com.ln.microsservice.usuario.Persistance.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String mensagem;
    @ManyToOne
    private Usuario usuario;
    @JdbcTypeCode(SqlTypes.JSON)
    private Object data;
    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
