package com.ln.microsservice.bff.Presentation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ln.microsservice.bff.Business.Services.InstituicaoService;
import com.ln.microsservice.bff.DTO.InstituicaoEnsinoDTO;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @PostMapping("/criar")
    public Boolean criarInstituicao(@RequestBody InstituicaoEnsinoDTO instituicao) {
        instituicaoService.criarInstituicao(instituicao);
        return true;
    }

    @GetMapping("/obter-todas")
    public ResponseEntity<?> obterTodasInstituicoes() {
        Collection<InstituicaoEnsinoDTO> instituicoes = instituicaoService.obterTodasInstituicoes();
        return ResponseEntity.ok(instituicoes);
    }

}
