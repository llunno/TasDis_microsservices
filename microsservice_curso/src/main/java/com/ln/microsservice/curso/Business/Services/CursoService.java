package com.ln.microsservice.curso.Business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;
import com.ln.microsservice.curso.DTO.MateriaDTO;
import com.ln.microsservice.curso.Persistance.Entities.Curso;
import com.ln.microsservice.curso.Persistance.Entities.Materia;
import com.ln.microsservice.curso.Persistance.Repositories.CursoRepository;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Collection<MateriaDTO> obterMateriasPorCurso(UUID cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        List<Materia> materiasDoCurso = (List<Materia>) curso.getMaterias();
        return materiasDoCurso.stream().map(MateriaDTO::new).toList();
    }
}
