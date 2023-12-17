package com.masai.exception;

public class PaymentException extends RuntimeException {
  
	public PaymentException() {
		
	}
	
	public PaymentException(String message) {
		super(message);
	}
}
