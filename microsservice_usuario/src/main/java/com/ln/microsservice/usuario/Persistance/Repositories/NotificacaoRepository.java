package com.ln.microsservice.usuario.Persistance.Repositories;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ln.microsservice.usuario.Persistance.Entities.Notificacao;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, UUID> {
    
    @Query("SELECT n FROM Notificacao n WHERE n.usuario.id = :usuarioId")
    Collection<Notificacao> findAllByUsuario(UUID usuarioId);
}
