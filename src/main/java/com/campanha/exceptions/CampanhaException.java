package com.campanha.exceptions;

public class CampanhaException extends Exception {

	/**
	 * Classe que representa uma exceção do serviço de campanha
	 * 
	 * @Autor: Leandro Silva
	 * @since: 11/2017
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoRetorno;
	private String mensagem;

	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
