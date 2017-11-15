package com.campanha.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Entidade que representa a associação entre um cliente e N campanhas
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

@Entity
public class ClienteCampanha implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ClienteCampanha() {
		this.clienteCampanha = new ClienteCampanhaPK();
	}
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@EmbeddedId
	private ClienteCampanhaPK clienteCampanha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteCampanhaPK getClienteCampanha() {
		return clienteCampanha;
	}

	public void setClienteCampanha(ClienteCampanhaPK clienteCampanha) {
		this.clienteCampanha = clienteCampanha;
	}



	

	
}
