package com.ln.microsservice.curso.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.ln.microsservice.curso.Persistance.Entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, UUID> {

}
