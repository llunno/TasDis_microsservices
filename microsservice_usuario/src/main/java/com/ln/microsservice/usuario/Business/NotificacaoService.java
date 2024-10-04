package com.ln.microsservice.usuario.Business;

import java.util.Collection;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.usuario.DTOs.NotificacaoDTO;
import com.ln.microsservice.usuario.Persistance.Entities.Notificacao;
import com.ln.microsservice.usuario.Persistance.Entities.Usuario;
import com.ln.microsservice.usuario.Persistance.Repositories.NotificacaoRepository;

import jakarta.persistence.EntityManager;

@Service
@RabbitListener(queues = "${notifications.queue}")
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
    @Autowired
    private EntityManager entityManager;

    @RabbitHandler
    public void criarNotificacao(String notificacaoJson) throws Exception {
        NotificacaoDTO notificacaoDTO = objectMapper.readValue(notificacaoJson, NotificacaoDTO.class);
        Notificacao notificacao = Notificacao.builder()
                .mensagem(notificacaoDTO.mensagem())
                .usuario(entityManager.getReference(Usuario.class, UUID.fromString(notificacaoDTO.usuarioId())))
                .data(notificacaoDTO.data())
                .build();
        notificacaoRepository.save(notificacao);
    }

    public Collection<NotificacaoDTO> obterNotificacoesPorUsuarioId(UUID usuarioId) {
        Collection<Notificacao> notificacoes = notificacaoRepository.findAllByUsuario(usuarioId);
        return notificacoes.stream().map(NotificacaoDTO::new).toList();
    }
}
