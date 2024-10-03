package com.ln.microsservice.bff.Business.Services;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.bff.Business.Config.AmqpConfig;
import com.ln.microsservice.bff.Business.Config.WebClientInstancesConfig;
import com.ln.microsservice.bff.DTO.InstituicaoEnsinoDTO;

@Service
public class InstituicaoService {

    @Autowired
    private AmqpConfig amqpConfig;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private WebClientInstancesConfig webClientEndpoints;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    public void criarInstituicao(InstituicaoEnsinoDTO instituicao) {
        try {
            String instituicaoDtoJson = objectMapper.writeValueAsString(instituicao);
            rabbitTemplate.convertAndSend(amqpConfig.instituicoesQueue().getName(), instituicaoDtoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Collection<InstituicaoEnsinoDTO> obterTodasInstituicoes() {
        List<InstituicaoEnsinoDTO> instituicoes = webClientEndpoints.webClientInstituicaoDomain().get()
                .uri("/instituicao/obter-todas").retrieve().bodyToFlux(InstituicaoEnsinoDTO.class).collectList().block();
        return instituicoes;        
    }
}
