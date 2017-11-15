package com.campanha.exceptions;

/**
 * Classe criada para representar uma mensagem de retorno para os consumidores
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public class MensagemRetorno {

	public MensagemRetorno() {
		super();
	}

	public MensagemRetorno(String codigo, String msg) {
		this.setCodigo(codigo);
		this.setMensagem(msg);
	}

	private String codigo;
	private String mensagem;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
