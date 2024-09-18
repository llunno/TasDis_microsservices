package com.ln.microsservice.bff.Presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ln.microsservice.bff.Business.Services.TarefaService;
import com.ln.microsservice.bff.DTO.TarefaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/criar-tarefa")
    public ResponseEntity<?> criarTarefa(@RequestBody TarefaDTO entity) throws JsonProcessingException {
        tarefaService.criarTarefa(entity);
        return ResponseEntity.ok().build();
    }   
}
