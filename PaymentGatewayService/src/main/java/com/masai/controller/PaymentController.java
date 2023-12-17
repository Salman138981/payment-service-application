package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Payment;
import com.masai.model.PaymentRequest;
import com.masai.model.User;
import com.masai.service.PaymentService;
import com.masai.service.UserService;

@RestController
public class PaymentController {
   
	  @Autowired
	    private PaymentService paymentService;
	  
	  @Autowired
	  private UserService userService;

	    @GetMapping("/payments")
	    public ResponseEntity<List<Payment>> getAllPayments() {
	        List<Payment> payments = paymentService.getAllPayments();
	        return new ResponseEntity<>(payments, HttpStatus.OK);
	    }

	    @GetMapping("/payments/{paymentId}")
	    public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") Long paymentId) {
	        Payment payment = paymentService.getPaymentById(paymentId);
	        return new ResponseEntity<>(payment, HttpStatus.OK);
	    }

	    @PostMapping("payments/process")
	    public ResponseEntity<Payment> processPayment(@RequestBody PaymentRequest paymentRequest) {
	      
	        Payment payment = paymentService.processPayment(paymentRequest);
	        return new ResponseEntity<>(payment, HttpStatus.CREATED);
	    }

	    @GetMapping("payments/user/{userId}")
	    public ResponseEntity<List<Payment>> getAllPaymentsByUser(@PathVariable("userId") Long userId) {
	        List<Payment> payments = paymentService.getAllPaymentsByUser(userId);
	        return new ResponseEntity<>(payments, HttpStatus.OK);
	    }
}
