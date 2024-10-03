package com.ln.microsservice.curso.Business.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Value("${cursos.queue}")
    private String cursosqueue;
    @Value("${materias.queue}")
    private String materiasqueue;

    @Bean
    public Queue cursosqueue() {
        return new Queue(cursosqueue, true);
    }

    @Bean
    public Queue materiasQueue() {
        return new Queue(materiasqueue, true);
    }
}
