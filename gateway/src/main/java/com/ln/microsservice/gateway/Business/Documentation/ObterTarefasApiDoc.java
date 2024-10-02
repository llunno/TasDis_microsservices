package com.ln.microsservice.gateway.Business.Documentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Operation;

@Operation(summary = "Obtém as tarefas para o aluno especificado", description = "Obtém todas as tarefas do backend para o aluno especificado")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ObterTarefasApiDoc {

}
