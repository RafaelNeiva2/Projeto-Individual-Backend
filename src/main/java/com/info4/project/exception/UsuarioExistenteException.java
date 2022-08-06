package com.info4.project.exception;

public class UsuarioExistenteException extends Exception {
	
	public String message;

	public UsuarioExistenteException(String message) {
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
