package com.ln.microsservice.bff.Business.Services;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.ln.microsservice.bff.Business.Config.WebClientInstancesConfig;

@Service
public class ObterIdsRelacoesService {

    @Autowired
    private WebClientInstancesConfig webClientEndpoints;

    public Collection<UUID> getCursosIdByEstudante(UUID estudanteId) {
        return webClientEndpoints.webClientUsuarioDomain()
                .get()
                .uri("/estudante/" + estudanteId + "/cursos-matriculados")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Collection<UUID>>() {
                })
                .block();
    }
}
