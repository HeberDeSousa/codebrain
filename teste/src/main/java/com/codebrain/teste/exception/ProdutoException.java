package com.codebrain.teste.exception;

public class ProdutoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 362986190814618808L;
	
	public ProdutoException() {
	}

	public ProdutoException(String msg, Throwable t) {
		super(msg, t);
	}

	public ProdutoException(String msg) {
		super(msg);
	}

}
