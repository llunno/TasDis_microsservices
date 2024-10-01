package com.ln.microsservice.curso;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ln.microsservice.curso.Persistance.Entities.Curso;
import com.ln.microsservice.curso.Persistance.Entities.Materia;
import com.ln.microsservice.curso.Persistance.Repositories.CursoRepository;
import com.ln.microsservice.curso.Persistance.Repositories.MateriaRepository;

@SpringBootTest
public class PopulateCursoDB {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private MateriaRepository materiaRepository;

    @Test
    void populate() {
        UUID idMateria = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");
        UUID idCurso = UUID.fromString("507d0598-9f9f-4083-bb8e-daa417d40a51");
        UUID idInstituicoesEnsino = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");

        Curso curso = Curso.builder()
                .id(idCurso)
                .name("Curso de Java")
                .descricao("Curso de Java para iniciantes")
                .cargaHoraria(40.0f)
                .instituicaoEnsino(idInstituicoesEnsino)
                .build();

        Materia materia = Materia.builder()
                .id(idMateria)
                .nome("Java")
                .descricao("Java para iniciantes")
                .build();
        
        curso.addMateria(materia);
        materia.addCurso(curso);

        cursoRepository.save(curso);
        materiaRepository.save(materia);
    }
}
