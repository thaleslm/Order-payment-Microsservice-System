package com.dev.Order_payment_Microsservice_System.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitmqConfig {

    @Value("${queue.name.order}")
    public String QUEUE_NAME;
    @Value("${queue.exchange.order}")
    public String QUEUE_EXCHANGE ;
    @Value("${queue.routing.key.order}")
    public String ORDER_KEY_QUEUE ;

    @Bean
    public Queue queue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public DirectExchange queueExchange(){
        return new DirectExchange(QUEUE_EXCHANGE);
    }

    //Binding bettween exchange and queue
    @Bean
    public Binding bindingQueue(){
        return BindingBuilder
                .bind(queue())
                .to(queueExchange())
                .with(ORDER_KEY_QUEUE);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

}
