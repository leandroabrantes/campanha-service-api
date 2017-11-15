package com.campanha.service;

import com.campanha.model.Campanha;

/**
 * Interface que especifica um contrato de utilização para o serviço de notificação aos demais sistemas.
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public interface CampanhaNotificacaoService {

	public void notificar(Campanha campanha);

}
