package com.ln.microsservice.gateway.Business.Documentation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.lang.annotation.ElementType;

@RequestBody(
    description = "Cria um novo aluno",
    required = true,
    content = {
        @Content(
            mediaType = "application/json",
            examples = {
                @ExampleObject(
                    name = "Exemplo de requisição",
                    value = "{\n  \"nome\": \"John Doe\",\n" +
                    "\"dataNascimento\": \"1980-01-01\",\n" + 
                    "\"numeroContato\": 123456789,\n" +
                    "\"email\": \"john.doe@email.com\",\n" +
                    "\"senha\": \"password123\",\n" +
                    "\"matricula\": \"123456\",\n" +
                    "\"instituicaoEnsino\": \"550e8400-e29b-41d4-a716-446655440003\"\n}"
                )
            }
        ),
    }
)
@Operation(summary = "Cria um novo aluno", description = "Cria um novo aluno no sistema")
@Target(ElementType.METHOD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface NovoAlunoApiDoc {

}
