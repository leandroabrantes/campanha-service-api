package com.campanha.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campanha.integracao.CampanhaNotificacao;
import com.campanha.integracao.CampanhaTopicSender;
import com.campanha.model.Campanha;
import com.campanha.service.CampanhaNotificacaoService;

/**
 * 
 * @author Leandro Silva
 *
 *Classe responsavel por notificar os sistemas interessados que uma campanha vigente foi alterada.
 */


@Component
public class CampanhaNotificacaoServiceImpl implements CampanhaNotificacaoService {
    
	@Autowired
	CampanhaTopicSender sender;
	
	public void notificar(Campanha campanha) {
		
		CampanhaNotificacao notificacao = new CampanhaNotificacao();
		
		notificacao.setFrom("CampanhaService");
		notificacao.setTo("Sistemas interessados");
		notificacao.setCampanha(campanha);
		notificacao.setData(LocalDateTime.now());
		
		sender.sendTopic(notificacao);
		
	}
	
}
