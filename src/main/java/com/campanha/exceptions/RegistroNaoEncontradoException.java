package com.campanha.exceptions;

public class RegistroNaoEncontradoException extends CampanhaException {

	/**
	 * Classe de exceção customizada para tratamento de registro nao encontrado em uma busca.
	 * 
	 * @Autor: Leandro Silva
	 * @since: 11/2017
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RegistroNaoEncontradoException() {
		super();
		this.setCodigoRetorno("-1");
		this.setMensagem("Nenhum registro Encontrado");
	}
	

}
