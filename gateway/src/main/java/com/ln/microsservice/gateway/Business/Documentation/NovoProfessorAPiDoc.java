package com.ln.microsservice.gateway.Business.Documentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestBody(description = "Cria um novo professor", required = true, content = {
        @Content(mediaType = "application/json", examples = {
                @ExampleObject(name = "Exemplo de requisição", value = "{"
                        + "\"nome\": \"John Doe\","
                        + "\"dataNascimento\": \"1980-01-01\","
                        + "\"numeroContato\": 123456789,"
                        + "\"endereco\": \"\","
                        + "\"email\": \"john.doe@example.com\","
                        + "\"senha\": \"password123\","
                        + "\"matricula\": \"123456\","
                        + "\"materiasLecionadas\": ["
                        + "\"550e8400-e29b-41d4-a716-446655440001\","
                        + "\"550e8400-e29b-41d4-a716-446655440002\""
                        + "],"
                        + "\"instituicaoEnsino\": \"550e8400-e29b-41d4-a716-446655440003\""
                        + "}") }

        )
})
@Operation(summary = "Cria um novo professor", description = "Cria um novo professor no sistema")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NovoProfessorAPiDoc {

}
