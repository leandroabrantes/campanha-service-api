package com.campanha.integracao;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.campanha.model.Campanha;

/**
 *  Classe criada para realizar a integração da api de campanhas com os demais sistemas
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public class CampanhaNotificacao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String from;
	private String to;
	private Campanha campanha;
	private LocalDateTime data;

	public CampanhaNotificacao() {
	}

	public CampanhaNotificacao(String from, String to, Campanha campanha, LocalDateTime timestamp) {
		this.from = from;
		this.to = to;
		this.campanha = campanha;
		this.data = timestamp;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalDateTime getTimestamp() {
		return data;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.data = timestamp;
	}

	@Override
	public String toString() {
		return "Order{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", campanha=" + campanha + ", timestamp="
				+ data + '}';
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
