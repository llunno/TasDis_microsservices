package com.ln.microsservice.curso.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import com.ln.microsservice.curso.Persistance.Entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, UUID> {


    @Query("SELECT m FROM Materia m JOIN m.cursos c WHERE c.id = :cursoId")
    List<Materia> findAllByCurso(UUID cursoId);
}
