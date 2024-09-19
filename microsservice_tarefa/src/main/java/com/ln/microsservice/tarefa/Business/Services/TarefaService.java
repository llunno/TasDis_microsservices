package com.ln.microsservice.tarefa.Business.Services;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.tarefa.DTO.TarefaDTO;
import com.ln.microsservice.tarefa.Persistance.Entities.Tarefa;
import com.ln.microsservice.tarefa.Persistance.Repositories.TarefaRepository;

@Service
@RabbitListener(queues = "${queue.name}")
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
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
        tarefaRepository.save(tarefa);
    }

    public Collection<TarefaDTO> obterTodasTarefasPorMateria(UUID materiaId) {
        Collection<Tarefa> tarefas = tarefaRepository.findAllByMateria(materiaId)
                .orElseThrow(() -> new NullPointerException("Nenhuma tarefa encontrada"));
        return tarefas.stream().map(TarefaDTO::new).collect(Collectors.toList());
    }
}
