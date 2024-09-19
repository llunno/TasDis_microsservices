package com.ln.microsservice.curso.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.ln.microsservice.curso.Persistance.Entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID> {

}
