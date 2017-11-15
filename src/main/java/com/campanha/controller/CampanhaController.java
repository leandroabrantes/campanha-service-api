package com.campanha.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campanha.exceptions.MensagemRetorno;
import com.campanha.exceptions.RegistroNaoEncontradoException;
import com.campanha.model.Campanha;
import com.campanha.request.CampanhaRequest;
import com.campanha.response.CampanhaResponse;
import com.campanha.response.ClienteCampanhaResponse;
import com.campanha.service.CampanhaService;


/**
 * Controller responsavel por realizar as operacoes relacionadas a Campanha(CRUD)
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

@RestController
@RequestMapping("/campanha")
public class CampanhaController {

	@Autowired
	private CampanhaService service;

	@GetMapping("/consulta")
	public ResponseEntity<CampanhaResponse> consultar(CampanhaRequest request) throws RegistroNaoEncontradoException {
		CampanhaResponse response = new CampanhaResponse(); 
		response.getCampanhas().add(service.consultar(request.getCodigo()));
		return new ResponseEntity<CampanhaResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<CampanhaResponse> listar() {
		CampanhaResponse response = new CampanhaResponse(); 
		response.setCampanhas(service.listar());
		return new ResponseEntity<CampanhaResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/buscaPorTime")
	public ResponseEntity<CampanhaResponse> consultarCampanhaPorTime(Long codigoTime) throws Exception {
		CampanhaResponse response = new CampanhaResponse(); 
		response.setCampanhas(service.consultaCampanhaPorTime(codigoTime));
		return new ResponseEntity<CampanhaResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/campanhaCliente")
	public ResponseEntity<ClienteCampanhaResponse> consultaCampanhaCliente(Long codigoCliente) throws Exception {
		ClienteCampanhaResponse response = new ClienteCampanhaResponse();
		response.setCampanhas(service.consultaCampanhaCliente(codigoCliente));
		return new ResponseEntity<ClienteCampanhaResponse>(response,HttpStatus.OK);
	}
	
	
    @PostMapping("/salva")
	public ResponseEntity<MensagemRetorno> salvar(CampanhaRequest request) throws Exception{
    	Campanha campanha = new Campanha();
    	BeanUtils.copyProperties(request, campanha);
        service.incluir(campanha,request.getTime());   
        return new ResponseEntity<MensagemRetorno>(new MensagemRetorno("0", "Campanha salva com sucesso"),HttpStatus.OK );
        
	}
 
    @DeleteMapping("/exclui")
	public ResponseEntity<MensagemRetorno> excluir(CampanhaRequest request) throws RegistroNaoEncontradoException{
    	service.excluir(request.getCodigo());
    	return new ResponseEntity<MensagemRetorno>(new MensagemRetorno("0", "Campanha excluída com sucesso"),HttpStatus.OK );
	}
    
    @PutMapping("/altera")
	public ResponseEntity<MensagemRetorno> alterar(CampanhaRequest request){
    	Campanha campanha = new Campanha();
    	BeanUtils.copyProperties(request, campanha);
    	service.alterar(campanha);
    	return new ResponseEntity<MensagemRetorno>(new MensagemRetorno("0", "Campanha alterada com sucesso"),HttpStatus.OK );
	}
    
    @GetMapping("/associaClienteCampanha")
    public ResponseEntity<MensagemRetorno> associarClienteCampanha(Long codigoCliente, Long campanha) throws Exception{
    	service.associarClienteCampanha(codigoCliente, campanha);
    	return new ResponseEntity<MensagemRetorno>(new MensagemRetorno("0", "Associacao realizada com sucesso"),HttpStatus.OK );
    	
    }
    
}
