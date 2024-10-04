package com.ln.microsservice.tarefa.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificacaoDTO(
    UUID id,
    String mensagem,
    String usuarioId,
    String data,
    LocalDateTime dataCriacao
) {

}
