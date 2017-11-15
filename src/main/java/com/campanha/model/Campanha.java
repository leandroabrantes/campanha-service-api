package com.campanha.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidade que representa uma campanha
 * 
 * @author Leandro Silva
 * 
 */

@Entity
public class Campanha implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Campanha() {
		super();
	}
	public Campanha(Long codigo,String	nome,Time time,Date dataInicio,Date dataFim) {
		this.codigo = codigo;
		this.nome = nome;
		this.time = time;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="nome",nullable=false)
	private String	nome;
   
	@ManyToOne
	@JoinColumn(name = "codigo_time", referencedColumnName = "codigo",nullable=false)
	@JsonIgnore
	private Time time;
    
	@Temporal(TemporalType.DATE)
	@Column(name="data_Inicio",nullable=false)
	private Date dataInicio;
    
	@Temporal(TemporalType.DATE)
	@Column(name="data_Fim",nullable=false)
	private Date dataFim;

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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
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

	
	
}
