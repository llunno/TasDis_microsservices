package com.ln.microsservice.usuario.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.ln.microsservice.usuario.Persistance.Entities.Notificacao;

public record NotificacaoDTO(
    UUID id,
    String mensagem,
    String usuarioId,
    String data,
    LocalDateTime dataCriacao
) {
    public NotificacaoDTO(Notificacao notificacao) {
        this(notificacao.getId(), notificacao.getMensagem(), notificacao.getUsuario().getId().toString(), notificacao.getData().toString(), notificacao.getDataCriacao());
    }
    
}
