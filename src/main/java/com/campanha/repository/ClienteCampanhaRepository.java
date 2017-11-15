package com.campanha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campanha.model.ClienteCampanha;


/**
 * Interface representa um Repository - Utiliza o Spring Data JPA
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */
public interface ClienteCampanhaRepository extends JpaRepository<ClienteCampanha, Long> {
	
	public List<ClienteCampanha> findByClienteCampanhaCodigoCliente(Long codigoCliente);

}
