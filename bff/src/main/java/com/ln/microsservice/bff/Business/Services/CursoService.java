package com.ln.microsservice.bff.Business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.ln.microsservice.bff.Business.Config.WebClientInstancesConfig;
import com.ln.microsservice.bff.DTO.MateriaDTO;

@Service
public class CursoService {

    @Autowired
    private WebClientInstancesConfig webClientEndpoints;

    public List<MateriaDTO> obterMateriasPorCurso(UUID cursoId) {
        List<MateriaDTO> materias = webClientEndpoints.webClientCursoDomain()
                .get()
                .uri("/curso/" + "/obter-materias?cursoId=" + cursoId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<MateriaDTO>>() {
                })
                .block();

        return materias;
    }
}
