package com.ln.microsservice.usuario.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ln.microsservice.usuario.Business.EstudanteService;
import com.ln.microsservice.usuario.Business.Utils.Endpoints;

@RestController
@RequestMapping(Endpoints.ESTUDANTE)
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @GetMapping("/{userId}/tarefas-pendentes")
    private ResponseEntity<?> obterTarefasPendentes(Integer userId) {
        return ResponseEntity.ok().body(service.obterTarefasPendentes(userId));
    }
}
