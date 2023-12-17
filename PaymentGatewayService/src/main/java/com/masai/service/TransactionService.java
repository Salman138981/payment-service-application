package com.masai.service;

import java.util.List;

import com.masai.model.Transaction;

public interface TransactionService {

    public List<Transaction> getAllTransactions();
    
    public List<Transaction> getAllTransactionsByUser(Long userId);

    public Transaction getTransactionById(Long transactionId);

   

   
}

