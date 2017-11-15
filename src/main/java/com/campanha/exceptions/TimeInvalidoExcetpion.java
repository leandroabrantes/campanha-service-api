package com.campanha.exceptions;

/**
 *  Classe de exceção customizada para tratamento um objeto time invalido
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public class TimeInvalidoExcetpion extends CampanhaException {

	private static final long serialVersionUID = 1L;

	public TimeInvalidoExcetpion(String codigo, String msg) {
		this.setCodigoRetorno(codigo);
		this.setMensagem(msg);
	}

}
