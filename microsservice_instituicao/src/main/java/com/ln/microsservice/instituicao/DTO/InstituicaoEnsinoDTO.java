package com.ln.microsservice.instituicao.DTO;

import java.util.UUID;

import com.ln.microsservice.instituicao.Persistance.Entities.InstituicaoEnsino;

public record InstituicaoEnsinoDTO(
        UUID id,
        String nome,
        String cnpj,
        String numeroContato,
        UUID endereco) {

        public InstituicaoEnsinoDTO(InstituicaoEnsino instituicao) {
                this(instituicao.getId(), instituicao.getNome(), instituicao.getCnpj(), instituicao.getNumeroContato(),
                                instituicao.getEndereco());
        }
}
