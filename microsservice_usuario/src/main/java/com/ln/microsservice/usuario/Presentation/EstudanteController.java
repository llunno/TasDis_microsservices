package com.ln.microsservice.usuario.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import com.ln.microsservice.usuario.Business.EstudanteService;
import com.ln.microsservice.usuario.Business.NotificacaoService;
import com.ln.microsservice.usuario.Business.Utils.Endpoints;
import com.ln.microsservice.usuario.DTOs.EstudanteDTO;

@RestController
@RequestMapping(Endpoints.ESTUDANTE)
public class EstudanteController {

    @Autowired
    private EstudanteService service;
    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping("/{userId}/cursos-matriculados")
    public ResponseEntity<?> obterCursosMatriculados(@PathVariable UUID userId) {
        return ResponseEntity.ok().body(service.obterCursosMatriculados(userId));
    }

    @GetMapping("/{userId}/instituicoes-matriculadas")
    public ResponseEntity<?> obterInstituicoesMatriculadas(@PathVariable UUID userId) {
        return ResponseEntity.ok().body(service.obterInstituicoesMatriculadas(userId));
    }

    @GetMapping("obter-todos-estudantes")
    public ResponseEntity<?> obterTodosEstudantes() {
        List<EstudanteDTO> estudantes = service.obterTodosEstudantes();
        return ResponseEntity.ok().body(estudantes);
    }

    @GetMapping("/{userId}/notificacoes")
    public ResponseEntity<?> obterNotificacoes(@PathVariable UUID userId) {
        return ResponseEntity.ok().body(notificacaoService.obterNotificacoesPorUsuarioId(userId));
    }
}
