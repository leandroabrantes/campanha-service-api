package com.campanha.integracao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Classe criada para enviar mensagens para um topico e informar os demais sistemas sobre mudanças em campanha
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

@Service
public class CampanhaTopicSender {
	private static Logger log = LoggerFactory.getLogger(CampanhaTopicSender.class);

	public static final String CAMPANHA_TOPIC = "campanha-topic";

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendTopic(CampanhaNotificacao campanha) {
		log.info("enviando notificacao) para o tópico <" + CAMPANHA_TOPIC + ">");
		jmsTemplate.convertAndSend(CAMPANHA_TOPIC, campanha);
	}
}
