package com.ln.microsservice.bff.DTO;

import java.util.UUID;

public record InstituicaoEnsinoDTO(
                UUID id,
                String nome,
                String cnpj,
                String numeroContato,
                UUID endereco) {

}
