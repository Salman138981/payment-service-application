package com.masai.exception;

public class TransactionException extends RuntimeException{
	
	public TransactionException() {
		
	}
	
     public TransactionException(String message) {
		super(message);
	}
	
}
