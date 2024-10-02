package com.ln.microsservice.curso.Presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ln.microsservice.curso.Business.Services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.UUID;
import com.ln.microsservice.curso.DTO.MateriaDTO;

import java.util.Collection;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/obter-materias")
    public ResponseEntity<?> obterMateriasPorCurso(@RequestParam UUID cursoId) {
        Collection<MateriaDTO> materias = cursoService.obterMateriasPorCurso(cursoId);
        return ResponseEntity.ok(materias);
    }
}
