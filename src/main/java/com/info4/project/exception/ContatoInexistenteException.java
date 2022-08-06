package com.info4.project.exception;

public class ContatoInexistenteException extends Exception {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ContatoInexistenteException(String message) {
		super();
		this.message = message;
	}
	
	

}
