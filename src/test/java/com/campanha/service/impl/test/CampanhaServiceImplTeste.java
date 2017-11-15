package com.campanha.service.impl.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.campanha.exceptions.RegistroNaoEncontradoException;
import com.campanha.model.Campanha;
import com.campanha.model.Time;
import com.campanha.repository.CampanhaRepository;
import com.campanha.repository.ClienteCampanhaRepository;
import com.campanha.service.CampanhaNotificacaoService;
import com.campanha.service.TimeService;
import com.campanha.service.impl.CampanhaServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class CampanhaServiceImplTeste {

	
	CampanhaServiceImpl service;
	
	@Mock
	CampanhaRepository repository;
	
	Campanha campanha;

	@Mock
	ClienteCampanhaRepository clienteCampanhaRepository;

	@Mock
	TimeService timeService;

	@Mock
	CampanhaNotificacaoService notificacao;
	@Mock
	List<Campanha> campanhas;
	
    Time time;
	
    @Before
	public void setupMock() {
    	
    	service = new CampanhaServiceImpl();
		service.setCampanhaRepository(repository);
		service.setNotificacao(notificacao);
		service.setTimeService(timeService);
		
		campanha = new Campanha();
		campanha.setCodigo(5L);
		campanha.setNome("Leandro");
		time = new Time();
		time.setCodigo(1L);
		time.setNome("SPFC");
		
		campanha.setTime(time);
		campanha.setDataInicio(new Date());
	}

	@Test
	public void consultarTest() throws Exception {
		when(repository.findOne(1L)).thenReturn(campanha);
		Campanha campanha = service.consultar(1L);
		assertThat(campanha, is(equalTo(campanha)));

	}

	@Test(expected = RegistroNaoEncontradoException.class)
	public void consultarTestException() throws RegistroNaoEncontradoException {
		when(repository.findOne(3L)).thenReturn(campanha);
		Campanha campanha;
		campanha = service.consultar(1L);
		if (campanha == null) {
			throw new RegistroNaoEncontradoException();
		}
	}
	
	@Test
	public void alterarTest() {
		when(repository.saveAndFlush(campanha)).thenReturn(campanha);
		Campanha request = campanha;
		Campanha campanha = repository.saveAndFlush(request);
		campanha = service.alterar(request);
		assertEquals(request, campanha);

	}
	
	@Test
	public void excluirTest() throws RegistroNaoEncontradoException {
		when(repository.findOne(5L)).thenReturn(campanha);
		doNothing().when(repository).delete(campanha);
		service.excluir(5L);

	}
    
	@Test(expected=RegistroNaoEncontradoException.class)
	public void excluirExceptionTest() throws RegistroNaoEncontradoException {
		when(repository.findOne(5L)).thenReturn(campanha);
		doNothing().when(repository).delete(campanha);
		service.excluir(3L);

	}
	
	@Test
	public void incluirTest() throws Exception {
		when(repository.saveAndFlush(campanha)).thenReturn(campanha);
		when(timeService.consultar(time.getCodigo())).thenReturn(time);
		service.incluir(campanha, time.getCodigo());

	}
	
}
