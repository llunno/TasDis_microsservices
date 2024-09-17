package com.ln.microsservice.usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ln.microsservice.usuario.Persistance.Entities.Estudante;
import com.ln.microsservice.usuario.Persistance.Entities.Professor;
import com.ln.microsservice.usuario.Persistance.Repositories.EstudanteRepository;
import com.ln.microsservice.usuario.Persistance.Repositories.ProfessorRepository;

@SpringBootTest
public class PopulateUserDB {

    @Autowired
    private EstudanteRepository userRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    void populate() {

        UUID idEstudante = UUID.fromString("79526cd4-345d-4b0d-a381-add03f450d47");
        UUID idProfessor = UUID.fromString("19d2217d-8f5d-4738-a495-d50b6d8aa33f");
        UUID idEnderecoEst = UUID.fromString("e99a4202-d074-45b7-9c27-ae987a875105");
        UUID idEnderecoProf = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");
        UUID idCursos = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");
        UUID idInstituicoesEnsino = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");
        UUID idMateriaLecionada = UUID.fromString("3f7442df-a11e-4738-8253-30a0c74622b5");

        Estudante estudante = Estudante.builder()
                .id(idEstudante)
                .nome("Lucas")
                .email("lucas@gmail.com")
                .senha("123@TestePass")
                .endereco(idEnderecoEst)
                .cursosMatriculados(List.of(idCursos))
                .dataNascimento(LocalDate.of(2005, 8, 1))
                .instituicoesEnsino(List.of(idInstituicoesEnsino))
                .numeroContato(123456789)
                .matricula("123456/est")
                .build();

        Professor professor = Professor.builder()
                .id(idProfessor)
                .nome("Paulo")
                .email("Paulo@gmail.com")
                .senha("123@TestePass")
                .endereco(idEnderecoProf)
                .materiasLecionadas(List.of(idMateriaLecionada))
                .dataNascimento(LocalDate.of(1999, 1, 1))
                .instituicoesEnsino(List.of(idInstituicoesEnsino))
                .numeroContato(987654321)
                .matricula("123456/pf")
                .build();

        userRepository.save(estudante);
        professorRepository.save(professor);
    }
}
