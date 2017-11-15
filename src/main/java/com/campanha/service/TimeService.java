package com.campanha.service;

import java.util.List;

import com.campanha.exceptions.RegistroNaoEncontradoException;
import com.campanha.exceptions.TimeInvalidoExcetpion;
import com.campanha.exceptions.ValidacaoException;
import com.campanha.model.Time;
/**
 * Interface que especifica um contrato das operações realizadas pela api de campanhas
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */
public interface TimeService {

	public void incluir(Time time) throws TimeInvalidoExcetpion, ValidacaoException;

	public List<Time> listar();

	public Time consultar(Long codigo) throws RegistroNaoEncontradoException;

	public List<Time> consultarPorNome(String nome) throws RegistroNaoEncontradoException;

	public void excluir(Long codigo) throws RegistroNaoEncontradoException;

	public Time alterar(Time time) throws Exception;

}
