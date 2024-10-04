package com.ln.microsservice.tarefa.Business.Services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.tarefa.Business.Config.AmqpConfig;
import com.ln.microsservice.tarefa.DTO.NotificacaoDTO;
import com.ln.microsservice.tarefa.DTO.TarefaDTO;
import com.ln.microsservice.tarefa.Persistance.Entities.Tarefa;
import com.ln.microsservice.tarefa.Persistance.Repositories.TarefaRepository;

@Service
@RabbitListener(queues = "${queue.name}")
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpConfig amqpConfig;
    private ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();

    public TarefaDTO obterTarefaPorId(UUID id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Tarefa nao encontrada"));
        return new TarefaDTO(tarefa);
    }

    @RabbitHandler
    public void criarTarefa(@Payload String tarefaObj) throws StreamReadException, DatabindException, IOException {
        TarefaDTO tarefaDTO = mapper.readValue(tarefaObj, TarefaDTO.class);
        Tarefa tarefa = new Tarefa(tarefaDTO);
        Tarefa tarefaFromDB = tarefaRepository.save(tarefa);
        new TarefaDTO(tarefaFromDB);
        NotificacaoDTO notificacao = new NotificacaoDTO(null, "Uma nova tarefa foi criada", tarefaFromDB.getProfessorCriador().toString(), mapper.writeValueAsString(tarefaDTO), LocalDateTime.now());
        String notificacaoDtoJson = mapper.writeValueAsString(notificacao);
        rabbitTemplate.convertAndSend(amqpConfig.tarefaCriadaQueue().getName(), notificacaoDtoJson);
    }

    public Collection<TarefaDTO> obterTodasTarefasPorMateria(UUID materiaId) {
        Collection<Tarefa> tarefas = tarefaRepository.findAllByMateria(materiaId);
        return tarefas.stream().map(TarefaDTO::new).collect(Collectors.toList());
    }

    public Collection<TarefaDTO> obterTodasTarefas() {
        return tarefaRepository.findAll().stream().map(TarefaDTO::new).collect(Collectors.toList());
    }

    public Collection<TarefaDTO> obterTodasTarefasPorProfessor(UUID professorId) {
        Collection<Tarefa> tarefas = tarefaRepository.findAllByProfessorCriador(professorId);
        return tarefas.stream().map(TarefaDTO::new).collect(Collectors.toList());
    }
}
