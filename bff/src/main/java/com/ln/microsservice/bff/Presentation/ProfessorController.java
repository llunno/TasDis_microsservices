package com.ln.microsservice.bff.Presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ln.microsservice.bff.Business.Services.ProfessorService;
import com.ln.microsservice.bff.Business.Services.TarefaService;
import com.ln.microsservice.bff.DTO.ProfessorRegisterReqDTO;
import com.ln.microsservice.bff.DTO.TarefaDTO;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/criar-tarefa")
    public ResponseEntity<?> criarTarefa(@RequestBody TarefaDTO entity) throws JsonProcessingException {
        tarefaService.criarTarefa(entity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("novo-professor")
    public ResponseEntity<?> criarProfessor(@RequestBody ProfessorRegisterReqDTO entity) throws JsonProcessingException {
        professorService.criarProfessor(entity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tarefas/obter-todas")
    public ResponseEntity<?> obterTodasTarefas(@RequestParam UUID professorId) {
        return ResponseEntity.ok(tarefaService.obterTodasTarefasPorProfessor(professorId));
    }
}
