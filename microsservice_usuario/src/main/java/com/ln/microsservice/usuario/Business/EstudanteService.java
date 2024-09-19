package com.ln.microsservice.usuario.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;

import com.ln.microsservice.usuario.Business.Exceptions.NotFoundException;
import com.ln.microsservice.usuario.Persistance.Entities.Estudante;
import com.ln.microsservice.usuario.Persistance.Repositories.EstudanteRepository;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Collection<UUID> obterCursosMatriculados(UUID userId) {
        Estudante estudante = estudanteRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Estudante nao encontrado"));
        return estudante.getCursosMatriculados();
    }

    public UUID obterInstituicoesMatriculadas(UUID userId) {
        Estudante estudante = estudanteRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Estudante nao encontrado"));
        return estudante.getInstituicaoEnsino();
    }
}
