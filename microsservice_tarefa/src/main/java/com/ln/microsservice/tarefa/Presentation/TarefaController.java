package com.ln.microsservice.tarefa.Presentation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ln.microsservice.tarefa.Business.Services.TarefaService;
import com.ln.microsservice.tarefa.DTO.TarefaDTO;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping("/obter")
    public ResponseEntity<?> obterTarefaPorId(@RequestParam UUID id) {
        TarefaDTO tarefa = service.obterTarefaPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping("/obter-todas-por-materia")
    public ResponseEntity<?> obterTodasTarefasPorMateria(@RequestParam UUID materiaId) {
        return ResponseEntity.ok(service.obterTodasTarefasPorMateria(materiaId));
    }
}
