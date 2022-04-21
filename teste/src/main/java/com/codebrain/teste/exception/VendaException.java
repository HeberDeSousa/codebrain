package com.codebrain.teste.exception;

public class VendaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6274618217905574086L;
	
	public VendaException() {
	}

	public VendaException(String msg, Throwable t) {
		super(msg, t);
	}

	public VendaException(String msg) {
		super(msg);
	}

}
