package com.campanha;

import javax.jms.ConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

/**
 * Classe de inicialização da api.
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

@SpringBootApplication
@EnableJms
public class CampanhaApplication { 
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CampanhaApplication.class, args);
	}	
	@Bean
	public ActiveMQQueue activeMQ() {
		return new ActiveMQQueue("queue");
	}
	
	@Bean
	JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
		SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}


}
