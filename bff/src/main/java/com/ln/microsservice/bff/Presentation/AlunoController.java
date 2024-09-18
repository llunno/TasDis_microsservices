package com.ln.microsservice.bff.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
import com.ln.microsservice.bff.Business.Services.TarefaService;
import com.ln.microsservice.bff.DTO.TarefaDTO;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/{userId}/tarefas-pendentes")
    public ResponseEntity<?> getTarefasPendentes(@PathVariable UUID userId) {
        List<TarefaDTO> tarefasPendentes = tarefaService.getTarefasPendentes(userId);
        return ResponseEntity.ok(tarefasPendentes);
    }
}
