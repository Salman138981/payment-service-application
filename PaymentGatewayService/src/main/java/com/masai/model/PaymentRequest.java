package com.masai.model;

public class PaymentRequest {
   
	 private Long userId;
	    private Double amount;

	    

	    public PaymentRequest() {
	    }

	    public PaymentRequest(Long userId, Double amount) {
	        this.userId = userId;
	        this.amount = amount;
	    }

	   

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }
}
