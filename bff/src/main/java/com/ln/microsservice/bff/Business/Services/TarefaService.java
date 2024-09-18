package com.ln.microsservice.bff.Business.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ln.microsservice.bff.Business.Config.WebClientInstancesConfig;
import com.ln.microsservice.bff.DTO.TarefaDTO;

@Service
public class TarefaService {

    @Autowired
    private WebClientInstancesConfig webClientEndpoints;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue tarefasQueue;

    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    public List<TarefaDTO> getTarefasPendentes(UUID userId) {

        List<UUID> idsTarefasPendentes = webClientEndpoints.webClientUsuarioDomain()
                .get()
                .uri("/estudante/" + userId + "/tarefas-pendentes")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UUID>>() {
                })
                .block();

        List<TarefaDTO> tarefasPendentes = new ArrayList<>();

        if (idsTarefasPendentes == null) {
            return tarefasPendentes;
        }

        idsTarefasPendentes.forEach(id -> {
            TarefaDTO tarefa = webClientEndpoints.webClientTarefaDomain()
                    .get()
                    .uri("/tarefa/obter?id=" + id)
                    .retrieve()
                    .bodyToMono(TarefaDTO.class)
                    .block();
            tarefasPendentes.add(tarefa);
        });

        return tarefasPendentes;
    }

    public void criarTarefa(TarefaDTO entity) throws JsonProcessingException {
        String tarefaDtoJson = objectMapper.writeValueAsString(entity);
        rabbitTemplate.convertAndSend(tarefasQueue.getName(), tarefaDtoJson);
    }
}
