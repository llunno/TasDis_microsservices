package com.ln.microsservice.instituicao.Business.Services;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.instituicao.DTO.InstituicaoEnsinoDTO;
import com.ln.microsservice.instituicao.Persistance.Entities.InstituicaoEnsino;
import com.ln.microsservice.instituicao.Persistance.Repositories.InstituicaoRepository;

@Service
@RabbitListener(queues = "${queue.name}")
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    @RabbitHandler
    public void criarInstituicao(@Payload String instituicaoJson) throws Exception {
        InstituicaoEnsinoDTO instituicaoDTO = objectMapper.readValue(instituicaoJson,
                InstituicaoEnsinoDTO.class);
        InstituicaoEnsino instituicao = InstituicaoEnsino.builder()
                .nome(instituicaoDTO.nome())
                .numeroContato(instituicaoDTO.numeroContato())
                .cnpj(instituicaoDTO.cnpj())
                .build();
        instituicaoRepository.save(instituicao);
    }

    public Collection<InstituicaoEnsinoDTO> obterTodasInstituicoes() {
        List<InstituicaoEnsino> instituicoes = instituicaoRepository.findAll();
        return instituicoes.stream().map(InstituicaoEnsinoDTO::new).toList();
    }

    public InstituicaoEnsinoDTO obterInstituicaoPorId(UUID instituicaoId) {
        InstituicaoEnsino instituicao = instituicaoRepository.findById(instituicaoId).orElse(null);
        return instituicao != null ? new InstituicaoEnsinoDTO(instituicao) : null;
    }
}
