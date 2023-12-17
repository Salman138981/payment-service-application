package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Transaction;
import com.masai.service.TransactionService;

@RestController
public class TransactionController {
   
	    @Autowired
	    private TransactionService transactionService;

	    @GetMapping("/transactions")
	    public ResponseEntity<List<Transaction>> getAllTransactions() {
	        List<Transaction> transactions = transactionService.getAllTransactions();
	        return new ResponseEntity<>(transactions, HttpStatus.OK);
	    }

	    @GetMapping("transactions/{transactionId}")
	    public ResponseEntity<Transaction> getTransactionById(@PathVariable("transactionId") Long transactionId) {
	        Transaction transaction = transactionService.getTransactionById(transactionId);
	        return new ResponseEntity<>(transaction, HttpStatus.OK);
	    }

	    @GetMapping("transactions/payment/{paymentId}")
	    public ResponseEntity<List<Transaction>> getAllTransactionsByUser(@PathVariable("paymentId") Long userId) {
	        List<Transaction> transactions = transactionService.getAllTransactionsByUser(userId);
	        return new ResponseEntity<>(transactions, HttpStatus.OK);
	    }
}
