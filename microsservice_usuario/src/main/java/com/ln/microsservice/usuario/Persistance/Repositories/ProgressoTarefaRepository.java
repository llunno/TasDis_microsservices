package com.ln.microsservice.usuario.Persistance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.ln.microsservice.usuario.Persistance.Entities.ProgressoTarefa;

@Repository
public interface ProgressoTarefaRepository extends JpaRepository<ProgressoTarefa, UUID> {

}
