package com.campanha.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.exceptions.MensagemRetorno;
import com.campanha.exceptions.RegistroNaoEncontradoException;
import com.campanha.model.Time;
import com.campanha.response.TimeResponse;
import com.campanha.service.TimeService;


@RestController
@RequestMapping("/time")
public class TimeController implements Serializable {

	/**
	 * Controller responsavel por receber as requisições relacionadas aos Times(CRUD)
	 * 
	 * @Autor: Leandro Silva
	 * @since: 11/2017
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TimeService service;

	@GetMapping("/consultaPorNome")
	public ResponseEntity<TimeResponse> consultarPorNome(@RequestParam("nome")String nome) throws RegistroNaoEncontradoException {

		TimeResponse response = new TimeResponse(); 
		response.setTimes(service.consultarPorNome(nome));
		return new ResponseEntity<TimeResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/buscaPorCodigo")
	public ResponseEntity<TimeResponse> consultarPorCodigo(@RequestParam(name="codigo") Long codigo) throws RegistroNaoEncontradoException {
		TimeResponse response = new TimeResponse(); 
		response.getTimes().add(service.consultar(codigo));
		return new ResponseEntity<TimeResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<TimeResponse> listar() {
		TimeResponse response = new TimeResponse(); 
		response.setTimes(service.listar());
		
		return new ResponseEntity<TimeResponse>(response,HttpStatus.OK);
	}
    @PostMapping("/salva")
	public ResponseEntity<MensagemRetorno> salvar(String nome) throws Exception{
    	Time time = new Time();
    	time.setNome(nome);
    	
        service.incluir(time);   
        return new ResponseEntity<MensagemRetorno>(new MensagemRetorno("0", "Time salvo com sucesso"),HttpStatus.OK );
		
        
	}
 
    @DeleteMapping("/delete")
	public ResponseEntity<MensagemRetorno> excluir(Long codigo) throws RegistroNaoEncontradoException{
    	service.excluir(codigo);
    	return new ResponseEntity<MensagemRetorno>(new MensagemRetorno("0", "Time excluído com sucesso"),HttpStatus.OK );
	}
    
    @PutMapping("/update")
	public ResponseEntity<MensagemRetorno> alterar(Long codigo, String nome) throws Exception{
    	Time time = new Time();
    	time.setNome(nome);
    	time.setCodigo(codigo);
    	
    	service.alterar(time);
    	return new ResponseEntity<MensagemRetorno>(new MensagemRetorno("0", "Time alterado com sucesso"),HttpStatus.OK );
	}
    
       
}
