package com.campanha.service;

import java.util.List;

import com.campanha.exceptions.RegistroNaoEncontradoException;
import com.campanha.model.Campanha;
import com.campanha.model.ClienteCampanha;

/**
 * Interface que especifica um contrato das operações realizadas pela api de campanhas
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

public interface CampanhaService {
	
	public void incluir(Campanha campanha,Long codigoTime) throws Exception;
	
	public List<Campanha> listar();
	
	public List<Campanha> consultaCampanhaPorTime(Long codigoTime) throws Exception;
	
	public Campanha consultar(Long codigo) throws RegistroNaoEncontradoException;
	
	public List<ClienteCampanha> consultaCampanhaCliente(Long codigoCliente) throws Exception;
	
	public void excluir(Long codigo) throws RegistroNaoEncontradoException;
	
	public Campanha alterar(Campanha campanha);

	public void associarClienteCampanha(Long codigoCliente, Long campanha) throws Exception;

}
