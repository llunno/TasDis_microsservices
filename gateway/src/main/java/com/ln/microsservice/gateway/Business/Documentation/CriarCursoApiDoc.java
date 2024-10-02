package com.ln.microsservice.gateway.Business.Documentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Operation(
    summary = "Cria um novo curso",
    description = "Cria um novo curso no backend"
)
@RequestBody(
    description = "Objeto JSON contendo os dados do curso",
    required = true,
    content = @Content(
        mediaType = "application/json",
        examples = @ExampleObject(
            name = "Curso",
            value = "{\n" +
                    "  \"nome\": \"Course ABC\",\n" +
                    "  \"descricao\": \"Example description\",\n" +
                    "  \"cargaHoraria\": 40,\n" +
                    "  \"instituicaoEnsino\": \"123e4567-e89b-12d3-a456-426614174000\"\n" +
                    "}"
        )
    )
)
@ApiResponse(
    responseCode = "200",
    description = "Curso criado com sucesso",
    content = @Content(
        mediaType = "application/json",
        examples = @ExampleObject(
            name = "Sucesso",
            value = 
            "{\n" +
            "  \"timestamp\": \"02-10-2024 01:13:06\",\n" +
            "  \"message\": \"Example message\",\n" +
            "  \"data\": []\n" +
            "}"
        )
    )
)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CriarCursoApiDoc {

}
