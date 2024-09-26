package com.ln.microsservice.bff.Business.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.bff.Business.Config.WebClientInstancesConfig;
import com.ln.microsservice.bff.DTO.MateriaDTO;
import com.ln.microsservice.bff.DTO.TarefaDTO;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private WebClientInstancesConfig webClientEndpoints;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private ObterIdsRelacoesService obterIdsRelacoesService;
    @Autowired
    private Queue tarefasQueue;

    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    public List<TarefaDTO> getAllTarefas(UUID userId) {

        List<UUID> cursosId = (List<UUID>) obterIdsRelacoesService.getCursosIdByEstudante(userId);

        List<TarefaDTO> todasAsTarefas = cursosId.stream()
                .map(cursoId -> getTarefasPorCurso(cursoId))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return todasAsTarefas;
    }

    public void criarTarefa(TarefaDTO entity) throws JsonProcessingException {
        String tarefaDtoJson = objectMapper.writeValueAsString(entity);
        rabbitTemplate.convertAndSend(tarefasQueue.getName(), tarefaDtoJson);
    }

    public List<TarefaDTO> getTarefasPorCurso(UUID userId) {
        List<UUID> idsCursosMatriculados = (List<UUID>) obterIdsRelacoesService.getCursosIdByEstudante(userId);

        List<List<MateriaDTO>> materiasPorCurso = idsCursosMatriculados.stream()
                .map(cursoId -> cursoService.obterMateriasPorCurso(cursoId)).collect(Collectors.toList());

        List<MateriaDTO> materiaisConsolidados = materiasPorCurso.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<List<TarefaDTO>> tarefasPorMateria = new ArrayList<>();
        materiaisConsolidados.forEach(materia -> {
            List<TarefaDTO> tarefa = webClientEndpoints.webClientTarefaDomain()
                    .get()
                    .uri("/tarefa/obter-todas-por-materia?materiaId=" + materia.id())
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<TarefaDTO>>() {
                    })
                    .block();
            tarefasPorMateria.add(tarefa);
        });

        return tarefasPorMateria.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<TarefaDTO> getTarefasVencidas(UUID cursoId) {
        List<TarefaDTO> tarefasPorCurso = getTarefasPorCurso(cursoId);

        var tarefasVencidas = tarefasPorCurso.stream()
                .filter(tarefa -> tarefa.prazo().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());

        return tarefasVencidas;
    }

    public List<TarefaDTO> obterTodasTarefasPorProfessor(UUID professorId) {
        List<TarefaDTO> tarefas = webClientEndpoints.webClientTarefaDomain()
                .get()
                .uri("/tarefa/obter-todas-por-professor?professorId=" + professorId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TarefaDTO>>() {
                })
                .block();

        return tarefas;
    }
}
