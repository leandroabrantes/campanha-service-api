package com.campanha.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.campanha.model.Campanha;

/**
 * Classe representa um resposta do tipo CampanhaResponse para devolver os dados
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public class CampanhaResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Campanha> campanhas = new ArrayList<>();

	private String codigoRetorno;

	private String mensagemRetorno;

	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}

}
