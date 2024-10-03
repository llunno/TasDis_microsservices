package com.ln.microsservice.instituicao.Presentation;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ln.microsservice.instituicao.Business.Services.InstituicaoService;
import com.ln.microsservice.instituicao.DTO.InstituicaoEnsinoDTO;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping("/obter-todas")
    public ResponseEntity<?> obterTodasInstituicoes() {
        Collection<InstituicaoEnsinoDTO> instituicoes = instituicaoService.obterTodasInstituicoes();
        return ResponseEntity.ok(instituicoes);
    }

    @GetMapping("/obter-por-id")
    public ResponseEntity<?> obterInstituicaoPorId(@RequestParam UUID instituicaoId) {
        InstituicaoEnsinoDTO instituicao = instituicaoService.obterInstituicaoPorId(instituicaoId);
        return ResponseEntity.ok(instituicao);
    }
}
