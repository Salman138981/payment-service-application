package com.masai.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PaymentException;
import com.masai.exception.TransactionException;
import com.masai.model.Payment;
import com.masai.model.Transaction;
import com.masai.repository.PaymentRepository;
import com.masai.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<Transaction> getAllTransactions() {
		 List<Transaction> transactions = transactionRepository.findAll();

	        if (transactions.isEmpty()) {
	            throw new TransactionException("Transaction List is Empty");
	        }

	        return transactions;
	}
	
	 @Override
	  public List<Transaction> getAllTransactionsByUser(Long paymentId) {
	        Payment payment = paymentRepository.findById(paymentId)
	                .orElseThrow(() -> new PaymentException("payment not found"));

	             List<Transaction> transactions = payment.getTransactions();
	             return transactions;
	    }

	@Override
	public Transaction getTransactionById(Long transactionId) {
		  Optional<Transaction> op = transactionRepository.findById(transactionId);

	        if (op.isPresent()) {
	               Transaction t = op.get();
	               return t;
	        } else {
	            throw new TransactionException("Invalid Transaction Id");
	        }
	}

}
