package com.masai.service;

import java.util.List;

import com.masai.model.Payment;
import com.masai.model.PaymentRequest;
import com.masai.model.User;

public interface PaymentService {

    List<Payment> getAllPayments();
    
    public List<Payment> getAllPaymentsByUser(Long userId);;

    public Payment getPaymentById(Long paymentId);

    public Payment processPayment(PaymentRequest paymentRequest);

  
}

