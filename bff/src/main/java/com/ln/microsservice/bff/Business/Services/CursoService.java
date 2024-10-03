package com.ln.microsservice.bff.Business.Services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.bff.Business.Config.AmqpConfig;
import com.ln.microsservice.bff.Business.Config.WebClientInstancesConfig;
import com.ln.microsservice.bff.DTO.CursoDTO;
import com.ln.microsservice.bff.DTO.MateriaDTO;

@Service
public class CursoService {

    @Autowired
    private AmqpConfig amqpConfig;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();


    @Autowired
    private WebClientInstancesConfig webClientEndpoints;

    public List<MateriaDTO> obterMateriasPorCurso(UUID cursoId) {
        List<MateriaDTO> materias = webClientEndpoints.webClientCursoDomain()
                .get()
                .uri("/curso/" + "/obter-materias?cursoId=" + cursoId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<MateriaDTO>>() {
                })
                .block();

        return materias;
    }

    public void criarCurso(CursoDTO curso) throws JsonProcessingException {
        String cursoDtoJson = objectMapper.writeValueAsString(curso);
        rabbitTemplate.convertAndSend(amqpConfig.cursosQueue().getName(), cursoDtoJson);
    }

    public void criarMateria(MateriaDTO curso) throws JsonProcessingException {
        String materiaDtoJson = objectMapper.writeValueAsString(curso);
        rabbitTemplate.convertAndSend(amqpConfig.materiasQueue().getName(), materiaDtoJson);
    }

    public List<CursoDTO> obterTodosCursos() {
        List<CursoDTO> cursos = webClientEndpoints.webClientCursoDomain()
                .get()
                .uri("/curso/obter-todos-cursos")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CursoDTO>>() {
                })
                .block();

        return cursos;
    }

    public List<MateriaDTO> obterTodasMateriasPorCurso(UUID cursoId) {
        List<MateriaDTO> materias = webClientEndpoints.webClientCursoDomain()
                .get()
                .uri("/curso/obter-todas-materias-por-curso?cursoId=" + cursoId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<MateriaDTO>>() {
                })
                .block();

        return materias;
    }
}
