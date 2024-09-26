package com.ln.microsservice.gateway.Business.Documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.servers.Server;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fasterxml.jackson.databind.JsonNode;

@OpenAPIDefinition(
    info = @Info(
        title = "Endpoints consumíveis pelo Frontend do sistema TasDis",
        version = "0.1",
        description = "Gateway para microsserviços do sistema TasDis." +
                      "TasDis é um sistema distribuído onde professores e alunos podem acompanhar e monitorar suas tarefas acadêmicas." +
                      "Este projeto foi desenvolvido para a turma de Engenharia de Software Escalável do Instituto Infnet." +
                      "Utiliza tecnologias e conceitos como Docker, DDD, Spring AMQP, Docker, RabbitMQ, Kubernetes, OpenAPI e outros para tornar isso possível."
    ),
    servers = {
        @Server(
            url = "http://localhost:8085/api",
            description = "Endereço Localhost do Gateway"
        )
    }
)
@Schema(
    implementation = JsonNode.class,
    description = "Documentação base para os endpoints do sistema TasDis"
)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseApiDoc {

}