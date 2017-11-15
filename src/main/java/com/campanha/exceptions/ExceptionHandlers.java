package com.campanha.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller responsavel por interceptar as exceções do sistema e realizar o tratamento.
 * 
 * @Autor: Leandro Silva
 * @since: 11/2017
 * 
 */

@ControllerAdvice
public class ExceptionHandlers {


  @ExceptionHandler(CampanhaException.class)
  public ResponseEntity<MensagemRetorno> tratarRegistroNaoEncontrado(CampanhaException  ex) {
	 
	  MensagemRetorno mensagem = new MensagemRetorno();
	  mensagem.setCodigo(ex.getCodigoRetorno());
	  mensagem.setMensagem(ex.getMensagem());
   
	  return new ResponseEntity<MensagemRetorno>(mensagem,HttpStatus.OK);
	  
  }
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<MensagemRetorno> tratarRegistroNaoEncontrado(Exception  ex) {
	 
	  MensagemRetorno mensagem = new MensagemRetorno();
	  mensagem.setCodigo("-1");
	  mensagem.setMensagem(ex.getMessage());
	  return new ResponseEntity<MensagemRetorno>(mensagem,HttpStatus.OK);
	  
  }
  
  @ExceptionHandler(ValidacaoException.class)
  public ResponseEntity<MensagemRetorno> tratarErroValidacao(ValidacaoException  ex) {
	 
	  MensagemRetorno mensagem = new MensagemRetorno();
	  mensagem.setCodigo(ex.getCodigoRetorno());
	  mensagem.setMensagem(ex.getMensagem());
   
	  return new ResponseEntity<MensagemRetorno>(mensagem,HttpStatus.OK);
	  
  }
}