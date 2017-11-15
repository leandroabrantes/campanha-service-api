package com.campanha.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe representa uma requisição para o serviço.
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public class CampanhaRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;

	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataFim;

	private Long time;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

}
