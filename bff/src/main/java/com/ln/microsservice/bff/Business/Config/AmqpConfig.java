package com.ln.microsservice.bff.Business.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Value("${tarefas.queue}")
    private String tarefasQueueName;
    @Value("${estudantes.queue}")
    private String estudantesQueueName;
    @Value("${professores.queue}")
    private String professoresQueueName;
    @Value("${instituicoes.queue}")
    private String instituicoesQueueName;
    @Value("${cursos.queue}")
    private String cursosQueueName;
    @Value("${materias.queue}")
    private String materiasQueueName;

    @Bean
    public Queue tarefasQueue() {
        return new Queue(tarefasQueueName, true);
    }

    @Bean
    public Queue estudantesQueue() {
        return new Queue(estudantesQueueName, true);
    }

    @Bean
    public Queue professoresQueue() {
        return new Queue(professoresQueueName, true);
    }

    @Bean
    public Queue instituicoesQueue() {
        return new Queue(instituicoesQueueName, true);
    }

    @Bean
    public Queue cursosQueue() {
        return new Queue(cursosQueueName, true);
    }

    @Bean
    public Queue materiasQueue() {
        return new Queue(materiasQueueName, true);
    }
}
