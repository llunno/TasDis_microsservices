package com.ln.microsservice.bff.Business.Services;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.bff.Business.Config.AmqpConfig;
import com.ln.microsservice.bff.Business.Config.WebClientInstancesConfig;
import com.ln.microsservice.bff.DTO.EstudanteDTO;
import com.ln.microsservice.bff.DTO.EstudanteRegisterReqDTO;

@Service
public class EstudanteService {

    @Autowired
    private AmqpConfig amqpConfig;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
    @Autowired
    private WebClientInstancesConfig webClientEndpoints;


    public void criarEstudante(EstudanteRegisterReqDTO estudante) throws JsonProcessingException {
        String estudanteDtoJson = objectMapper.writeValueAsString(estudante);
        rabbitTemplate.convertAndSend(amqpConfig.estudantesQueue().getName(), estudanteDtoJson);
    }

    public List<EstudanteDTO> getTodosEstudantes() {
        List<EstudanteDTO> estudantes = webClientEndpoints.webClientUsuarioDomain().get()
                .uri("/estudante/obter-todos-estudantes").retrieve().bodyToFlux(EstudanteDTO.class).collectList().block();
        return estudantes;
    }

    public JsonNode obterNotificacoes(UUID userId) {
        JsonNode notificacoes = webClientEndpoints.webClientUsuarioDomain().get()
                .uri("/estudante/" + userId + "/notificacoes").retrieve().bodyToMono(JsonNode.class).block();
        return notificacoes;
    }
}
