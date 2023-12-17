package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masai.exception.PaymentException;
import com.masai.exception.UserException;
import com.masai.model.Payment;
import com.masai.model.PaymentRequest;
import com.masai.model.Transaction;
import com.masai.model.User;
import com.masai.repository.PaymentRepository;
import com.masai.repository.TransactionRepository;
import com.masai.repository.UserRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	   @Autowired
	    private PaymentRepository paymentRepository;
	   
	   @Autowired
	   private TransactionRepository transactionRepository;
	   
	   @Autowired
	   private UserRepository userRepository;

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
	        
	    if (payments.isEmpty()) {
	         throw new PaymentException("Payment List is Empty");
	    }
	        
	    return payments;
	}
	
     @Override
	 public List<Payment> getAllPaymentsByUser(Long userId) {
	        User user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found"));

	        return paymentRepository.findByUser(user);
	    }

	@Override
	public Payment getPaymentById(Long paymentId) {
		 Optional<Payment> op = paymentRepository.findById(paymentId);
	        
	        if (op.isPresent()) {
	                 Payment pay = op.get();
	                 return pay;
	        } else {
	            throw new PaymentException("Invalid Payment Id");
	        }
	}

	 @Transactional
	 @Override
	 public Payment processPayment(PaymentRequest paymentRequest) {
	        Long userId = paymentRequest.getUserId();
	        
	       User user = userRepository.findById(userId).orElseThrow(() -> new UserException("UserId is invalid"));
	        
	        if (paymentRequest.getAmount() <= 0) {
	            throw new PaymentException("Invalid payment amount");
	        }

	        Payment payment = new Payment();
	        payment.setAmount(paymentRequest.getAmount());
	        payment.setUser(user);
	        payment.setPaymentDate(LocalDate.now());

	        Payment pay = paymentRepository.save(payment);

	        
	        Transaction transaction = new Transaction();
	        transaction.setAmount(paymentRequest.getAmount());
	        transaction.setPayment(pay);
	        transaction.setTransactionDate(LocalDateTime.now());

	        transactionRepository.save(transaction);

	       

	        return pay;
	    }

	   
	
}
