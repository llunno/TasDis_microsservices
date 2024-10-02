package com.ln.microsservice.bff.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ln.microsservice.bff.Business.Services.CursoService;
import com.ln.microsservice.bff.DTO.CursoDTO;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarCurso(@RequestBody CursoDTO curso) throws JsonProcessingException {
        cursoService.criarCurso(curso);
        return ResponseEntity.ok().build();
    }
}
