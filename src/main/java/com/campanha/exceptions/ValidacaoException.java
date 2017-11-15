package com.campanha.exceptions;

/**
 *  Classe de exceção customizada para representar erros de validaçoes
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public class ValidacaoException extends CampanhaException{

	private static final long serialVersionUID = 1L;
	
	public ValidacaoException(String codigo,String msg) {
		this.setCodigoRetorno(codigo);
		this.setMensagem(msg);
	}

}
