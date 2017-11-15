package com.campanha.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.campanha.exceptions.RegistroNaoEncontradoException;
import com.campanha.exceptions.TimeInvalidoExcetpion;
import com.campanha.exceptions.ValidacaoException;
import com.campanha.model.Campanha;
import com.campanha.model.ClienteCampanha;
import com.campanha.model.Time;
import com.campanha.repository.CampanhaRepository;
import com.campanha.repository.ClienteCampanhaRepository;
import com.campanha.service.CampanhaNotificacaoService;
import com.campanha.service.CampanhaService;
import com.campanha.service.TimeService;

/**
 * Classe de implementação contrato das operações realizadas pela api de campanhas
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

@Component
public class CampanhaServiceImpl implements CampanhaService {

	@Autowired
	CampanhaRepository campanhaRepository;

	@Autowired
	ClienteCampanhaRepository clienteCampanhaRepository;

	@Autowired
	TimeService timeService;

	@Autowired
	CampanhaNotificacaoService  notificacao;

	List<Campanha> campanhas ;

	@Override
	public void incluir(Campanha campanha, Long codigoTime) throws Exception {

		validarParametros(campanha, codigoTime);

		Time time;

		time = timeService.consultar(codigoTime);

		if(time == null) {
			throw new TimeInvalidoExcetpion("-1", "Time informado para cadastro não existe");
		}

		verificarCampanhaVigente(campanha);
		campanha.setTime(time);

		campanhaRepository.saveAndFlush(campanha);

	}	

	private void validarParametros(Campanha campanha, Long codigoTime) throws ValidacaoException {
		if (codigoTime == null)
			throw new ValidacaoException("-1", "O Time é obrigatório");

		if (campanha == null)
			throw new ValidacaoException("-1", "Campanha invalida");

		if (StringUtils.isEmpty(campanha.getNome()))
			throw new ValidacaoException("-1", "O nome da campanha é obrigatório");

		if (StringUtils.isEmpty(campanha.getDataInicio()))
			throw new ValidacaoException("-1", "A data de inicio é obrigatório");

		if (StringUtils.isEmpty(campanha.getDataInicio()))
			throw new ValidacaoException("-1", "A data fim é obrigatório");

	}

	@Override
	public List<Campanha> listar() {
		return campanhaRepository.listarCampanhaAtivas();
	}

	@Override
	public Campanha consultar(Long codigo) throws RegistroNaoEncontradoException {
		Campanha campanha = campanhaRepository.findOne(codigo);
		if(campanha == null) {
			throw new RegistroNaoEncontradoException();
		}

		return campanha;
	}

	@Override
	public void excluir(Long codigo) throws RegistroNaoEncontradoException {
		Campanha campanha = campanhaRepository.findOne(codigo);

		if(campanha == null) {
			throw new RegistroNaoEncontradoException();
		}

		campanhaRepository.delete(campanha);

	}

	@Override
	public Campanha alterar(Campanha campanha) {
		campanhaRepository.saveAndFlush(campanha);

		this.notificacao.notificar(campanha);

		return campanha;
	}

	@Override
	public void associarClienteCampanha(final Long codigoCliente, Long campanha) throws Exception {

		if(codigoCliente == null || codigoCliente.equals(Long.MIN_VALUE))
			throw new ValidacaoException("-1", "O codigo do cliente é obrigatorio");

		if(campanha == null || campanha.equals(Long.MIN_VALUE))
			throw new ValidacaoException("-1", "É necessario informar ao menos uma campanha para associação");


		ClienteCampanha clienteCampanha = new ClienteCampanha();
		clienteCampanha.getClienteCampanha().setCodigoCampanha(campanha);
		clienteCampanha.getClienteCampanha().setCodigoCliente(codigoCliente);
		this.clienteCampanhaRepository.save(clienteCampanha);
	}

	
	@SuppressWarnings("deprecation")
	private void verificarCampanhaVigente(Campanha campanha) {
		
		campanhas = campanhaRepository.listarCampanhasAtivaPorPeriodo(campanha.getDataInicio(),campanha.getDataFim());
		
		Date dataFim = new Date();
		for (Campanha c : campanhas) {
            dataFim.setDate(c.getDataFim().getDate() +1);
            alterarCampanhaAtiva(dataFim,campanha);
		}
		//Após o tratamento, persiste as campanhas e notifica os sistemas.
		for (Campanha c : campanhas) {
			
			this.alterar(c);
			this.notificarAlteracaoCampanha(c);
	  	}
	
	}

	@SuppressWarnings("deprecation")
	private void alterarCampanhaAtiva(Date dataFim, Campanha campanha) {
		  for (Campanha c : campanhas) {
			  if(c.getDataFim().after(dataFim)) {
				  c.getDataFim().setDate(c.getDataFim().getDate() +1);
			  }
			
			  if(c.getDataFim().equals(dataFim) ) {
				  c.getDataFim().setDate(c.getDataFim().getDate() +1);
			  }
		  }
	}
     
	private void notificarAlteracaoCampanha(Campanha campanha) {
		this.notificacao.notificar(campanha);;
	}

	@Override
	public List<ClienteCampanha> consultaCampanhaCliente(Long codigoCliente) throws Exception {
		return clienteCampanhaRepository.findByClienteCampanhaCodigoCliente(codigoCliente);
	}

	@Override
	public List<Campanha> consultaCampanhaPorTime(Long codigoTime) throws Exception {
		return campanhaRepository.consultaCampanhaPorTime(codigoTime);
	}

	public CampanhaRepository getCampanhaRepository() {
		return campanhaRepository;
	}

	public void setCampanhaRepository(CampanhaRepository campanhaRepository) {
		this.campanhaRepository = campanhaRepository;
	}

	public ClienteCampanhaRepository getClienteCampanhaRepository() {
		return clienteCampanhaRepository;
	}

	public void setClienteCampanhaRepository(ClienteCampanhaRepository clienteCampanhaRepository) {
		this.clienteCampanhaRepository = clienteCampanhaRepository;
	}

	public TimeService getTimeService() {
		return timeService;
	}

	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	public CampanhaNotificacaoService getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(CampanhaNotificacaoService notificacao) {
		this.notificacao = notificacao;
	}

	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

}