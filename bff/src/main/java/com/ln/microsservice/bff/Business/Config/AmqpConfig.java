package com.ln.microsservice.bff.Business.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Value("${tarefas.queue}")
    private String tarefasQueueName;

    @Bean
    public Queue tarefasQueue() {
        return new Queue(tarefasQueueName, true);
    }
}
