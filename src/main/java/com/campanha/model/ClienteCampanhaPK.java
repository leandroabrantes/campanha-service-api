package com.campanha.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Classe representa a chave composta da entidade ClienteCampanha
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

@Embeddable
public class ClienteCampanhaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigoCliente;

	private Long codigoCampanha;

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Long getCodigoCampanha() {
		return codigoCampanha;
	}

	public void setCodigoCampanha(Long codigoCampanha) {
		this.codigoCampanha = codigoCampanha;
	}

}
