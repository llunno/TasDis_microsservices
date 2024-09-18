package com.ln.microsservice.gateway.Business.Documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@OpenAPIDefinition(
    info = @Info(
        title = "Microsservice Gateway",
        version = "0.1",
        description = "Gateway para microsserviços do sistema TasDis"
    ),
    servers = {
        @Server(
            url = "http://localhost:8085/api",
            description = "Endereço Localhost do Gateway"
        )
    }
)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseApiDoc {

}
