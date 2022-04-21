package com.codebrain.teste.exception;

public class VendedorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7120747989338681045L;
	
	public VendedorException() {
	}

	public VendedorException(String msg, Throwable t) {
		super(msg, t);
	}

	public VendedorException(String msg) {
		super(msg);
	}

}
