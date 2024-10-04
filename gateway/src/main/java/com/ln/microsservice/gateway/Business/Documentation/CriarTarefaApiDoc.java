package com.ln.microsservice.gateway.Business.Documentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestBody(
    description = "Cria uma nova tarefa",
    required = true,
    content = {
        @Content(
            mediaType = "application/json",
            examples = {
                @ExampleObject(
                    name = "Exemplo de requisição",
                    value = "{\n  \"titulo\": \"Tarefa 1\",\n" +
                    "\"descricao\": \"Descrição da tarefa 1\",\n" + 
                    "\"prazo\": \"2021-12-31T23:59:59\",\n" +
                    "\"valorEmPontos\": 1,\n" +
                    "\"materia\": \"5e3429a5-2358-412b-be68-94e9d82cca5d\"\n," +
                    "\"professorCriador\": \"5e3429a5-2358-412b-be68-94e9d82cca5d\"" +
                    "}",
                    summary = "Exemplo de requisição para criar uma nova tarefa"
                )
            }
        )
    }
)
@Operation(
    summary = "Cria uma nova tarefa",
    description = "Cria uma nova tarefa no sistema. Tenha certeza que a matéria referenciada existe no sistema antes de tentar criar."
)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CriarTarefaApiDoc {

}
