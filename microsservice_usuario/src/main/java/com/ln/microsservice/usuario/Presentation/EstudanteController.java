package com.ln.microsservice.usuario.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import com.ln.microsservice.usuario.Business.EstudanteService;
import com.ln.microsservice.usuario.Business.Utils.Endpoints;

@RestController
@RequestMapping(Endpoints.ESTUDANTE)
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @GetMapping("/{userId}/cursos-matriculados")
    public ResponseEntity<?> obterCursosMatriculados(@PathVariable UUID userId) {
        return ResponseEntity.ok().body(service.obterCursosMatriculados(userId));
    }

    @GetMapping("/{userId}/instituicoes-matriculadas")
    public ResponseEntity<?> obterInstituicoesMatriculadas(@PathVariable UUID userId) {
        return ResponseEntity.ok().body(service.obterInstituicoesMatriculadas(userId));
    }
}
