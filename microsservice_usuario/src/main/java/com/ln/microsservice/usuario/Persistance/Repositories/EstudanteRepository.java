package com.ln.microsservice.usuario.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.ln.microsservice.usuario.Persistance.Entities.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, UUID> {

}
