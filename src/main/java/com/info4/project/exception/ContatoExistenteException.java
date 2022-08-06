package com.info4.project.exception;

public class ContatoExistenteException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ContatoExistenteException(String message) {
		super();
		this.message = message;
	}
	
	
}
