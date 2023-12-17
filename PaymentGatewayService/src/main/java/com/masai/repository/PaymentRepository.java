package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Payment;
import com.masai.model.User;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	 List<Payment> findByUser(User user);
}
