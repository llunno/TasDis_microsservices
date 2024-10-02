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
        version = "1",
        description = "Gateway para microsserviços do sistema TasDis." +
                      "TasDis é um sistema distribuído onde professores e alunos podem acompanhar e monitorar suas tarefas acadêmicas." +
                      "Este projeto foi desenvolvido para a turma de Engenharia de Software Escalável do Instituto Infnet." +
                      "Utiliza tecnologias e conceitos como Docker, DDD, Spring AMQP, Docker, RabbitMQ, Kubernetes, OpenAPI e outros para tornar isso possível.\n" +
                      "\n" +
                      "<strong>Orientação para testes no Swagger</strong>:\n" +
                      "1. Cadastre pelo menos uma instituição de ensino, um curso para esta instituição e uma matéria para este curso. Os exemplos das requests dos endpoints já estão neste padrão, então basta executá-los, na ordem informada anteriormente;\n" +
                      "2. Cadastre um professor. O professor é associado a uma ou mais matérias. Esta informação é necessária para que o professor possa criar tarefas para as matérias associadas a ele;\n" +
                      "3. Crie uma tarefa. A tarefa é associada a uma matéria. A tarefa é o objeto principal do sistema;\n" +
                      "4. Cadastre um aluno. O aluno é associado a um ou mais cursos. Se alguma matéria presente em um dos cursos que o aluno é matriculado tiver tarefas, este aluno é associado a ela automaticamente.\n" +
                      "5. A partir deste ponto, você pode listas todos os alunos, obter tarefas lançadas por um professor, obter tarefas do aluno, obter tarefas vencidas, etc."
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