package com.campanha.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.campanha.exceptions.RegistroNaoEncontradoException;
import com.campanha.exceptions.TimeInvalidoExcetpion;
import com.campanha.exceptions.ValidacaoException;
import com.campanha.model.Time;
import com.campanha.repository.TimeRepository;
import com.campanha.service.TimeService;

@Component
public class TimeServiceImpl implements TimeService {



	@Autowired
	TimeRepository timeRepository;



	@Override
	public void incluir(Time time) throws TimeInvalidoExcetpion, ValidacaoException {
		validarParametros(time);
		timeRepository.save(time);
	}


	@Override
	public List<Time> listar() {
		return timeRepository.findAll();
	}

	@Override
	public Time consultar(Long codigo) throws RegistroNaoEncontradoException {
		Time time = timeRepository.findOne(codigo);
		if(time == null) {
			throw new RegistroNaoEncontradoException();
		}
		return time;
	}

	@Override
	public void excluir(Long codigo) throws RegistroNaoEncontradoException {
		Time time = timeRepository.findOne(codigo);

		if(time == null) {
			throw new RegistroNaoEncontradoException();
		}
		timeRepository.delete(time);
	}

	@Override
	public Time alterar(Time time) throws Exception {
		validarParametros(time);

		timeRepository.saveAndFlush(time);
		return time;
	}



	@Override
	public List<Time> consultarPorNome(String nome) throws RegistroNaoEncontradoException {
		return timeRepository.findByNomeLike(nome);
	}

	private void validarParametros(Time time) throws ValidacaoException {
		if(time == null)
			throw new ValidacaoException("-1", "O Time não pode ser nulo."); 


		if(StringUtils.isEmpty(time.getNome()))
			throw new ValidacaoException("-1", "O nome do time é obrigatório");

	}
}