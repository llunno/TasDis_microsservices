package com.ln.microsservice.curso.Business.Services;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.curso.DTO.CursoDTO;
import com.ln.microsservice.curso.DTO.MateriaDTO;
import com.ln.microsservice.curso.Persistance.Entities.Curso;
import com.ln.microsservice.curso.Persistance.Entities.Materia;
import com.ln.microsservice.curso.Persistance.Repositories.CursoRepository;
import java.util.List;

@Service
@RabbitListener(queues = "${queue.name}")
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();


    public Collection<MateriaDTO> obterMateriasPorCurso(UUID cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        List<Materia> materiasDoCurso = (List<Materia>) curso.getMaterias();
        return materiasDoCurso.stream().map(MateriaDTO::new).toList();
    }

    @RabbitHandler
    public void criarCurso(@Payload String curso) throws JsonMappingException, JsonProcessingException {
        CursoDTO cursoDTO = objectMapper.readValue(curso, CursoDTO.class);
        Curso cursoEntity = Curso.builder()
                .name(cursoDTO.nome())
                .descricao(cursoDTO.descricao())
                .cargaHoraria(cursoDTO.cargaHoraria())
                .instituicaoEnsino(cursoDTO.instituicaoEnsino())
                .build();
        cursoRepository.save(cursoEntity);
    }
}
