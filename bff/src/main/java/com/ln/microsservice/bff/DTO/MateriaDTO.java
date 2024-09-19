package com.ln.microsservice.bff.DTO;

import java.util.UUID;

public record MateriaDTO(
    UUID id,
    String nome,
    String descricao
) {

}
