package com.ln.microsservice.usuario.Business;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.usuario.DTOs.ProfessorDTO;
import com.ln.microsservice.usuario.Persistance.Entities.Professor;
import com.ln.microsservice.usuario.Persistance.Repositories.ProfessorRepository;

@Service
@RabbitListener(queues = "${professores.queue}")
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    @RabbitHandler
    public void criarProfessor(String professorJson) throws Exception {
        ProfessorDTO professorDTO = objectMapper.readValue(professorJson, ProfessorDTO.class);
        Professor professor = Professor.builder()
                .nome(professorDTO.nome())
                .email(professorDTO.email())
                .senha(professorDTO.senha())
                .endereco(professorDTO.endereco())
                .materiasLecionadas(professorDTO.materiasLecionadas())
                .dataNascimento(professorDTO.dataNascimento())
                .instituicaoEnsino(professorDTO.instituicaoEnsino())
                .numeroContato(professorDTO.numeroContato())
                .matricula(professorDTO.matricula())
                .build();
        professorRepository.save(professor);
    }
}
