package com.ln.microsservice.bff.Presentation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ln.microsservice.bff.Business.Services.CursoService;
import com.ln.microsservice.bff.DTO.CursoDTO;
import com.ln.microsservice.bff.DTO.MateriaDTO;

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

    @PostMapping("/criar-materia")
    public ResponseEntity<?> criarMateria(@RequestBody MateriaDTO curso) throws JsonProcessingException {
        cursoService.criarMateria(curso);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/obter-todos-cursos")
    public ResponseEntity<?> obterTodosCursos() {
        return ResponseEntity.ok(cursoService.obterTodosCursos());
    }

    @GetMapping("/obter-todas-materias-por-curso")
    public ResponseEntity<?> obterTodasMateriasPorCurso(@RequestParam UUID cursoId) {
        return ResponseEntity.ok(cursoService.obterTodasMateriasPorCurso(cursoId));
    }
}
