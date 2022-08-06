package com.info4.project.exception;

public class UsuarioInexistenteException extends Exception {
	
	public String message;

	public UsuarioInexistenteException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
