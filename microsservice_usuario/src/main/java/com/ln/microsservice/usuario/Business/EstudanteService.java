package com.ln.microsservice.usuario.Business;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ln.microsservice.usuario.Business.Exceptions.NotFoundException;
import com.ln.microsservice.usuario.DTOs.EstudanteDTO;
import com.ln.microsservice.usuario.Persistance.Entities.Estudante;
import com.ln.microsservice.usuario.Persistance.Repositories.EstudanteRepository;

@Service
@RabbitListener(queues = "${queue.name}")
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;
    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    public Collection<UUID> obterCursosMatriculados(UUID userId) {
        Estudante estudante = estudanteRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Estudante nao encontrado"));
        return estudante.getCursosMatriculados();
    }

    public UUID obterInstituicoesMatriculadas(UUID userId) {
        Estudante estudante = estudanteRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Estudante nao encontrado"));
        return estudante.getInstituicaoEnsino();
    }

    @RabbitHandler
    public void criarEstudante(@Payload String estudanteJson) throws Exception {
        EstudanteDTO estudanteDTO = objectMapper.readValue(estudanteJson, EstudanteDTO.class);
        Estudante estudante = Estudante.builder()
                .nome(estudanteDTO.nome())
                .email(estudanteDTO.email())
                .senha(estudanteDTO.senha())
                .endereco(estudanteDTO.endereco())
                .cursosMatriculados(estudanteDTO.cursosMatriculados())
                .dataNascimento(estudanteDTO.dataNascimento())
                .instituicaoEnsino(estudanteDTO.instituicaoEnsino())
                .numeroContato(estudanteDTO.numeroContato())
                .matricula(estudanteDTO.matricula())
                .build();
        estudanteRepository.save(estudante);
    }

    public List<EstudanteDTO> obterTodosEstudantes() {
        List<Estudante> estudantes = estudanteRepository.findAll();
        return estudantes.stream().map(EstudanteDTO::new).toList();
    }
}
