package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.entity.PaymentMethod;
import com.example.entity.PaymentStatus;
import com.example.entity.Payments;
import com.example.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentrepository;
	
	public Payments initiatePayment(int dealerId, double amount, String paymentmethodstr) {
		PaymentMethod method_of_payment;  //PaymentMethod Enum Object reference
		try {
			method_of_payment = PaymentMethod.valueOf(paymentmethodstr.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Invalid Payment Type : " + paymentmethodstr);
		}
		Payments payment = new Payments(dealerId, amount, method_of_payment, PaymentStatus.PENDING, LocalDateTime.now());
		Payments savedPayment = paymentrepository.save(payment);
		
		simulatePaymentCallbackAsync(savedPayment.getPaymentID());
		
		return savedPayment;
	}
	
	@Async
	public CompletableFuture<Void> simulatePaymentCallbackAsync( int paymentId){
		try {
			Thread.sleep(5000);
			Payments payment = paymentrepository.findById(paymentId)
					.orElseThrow(()-> new RuntimeException("Payment not found with this Payment ID :" +paymentId));
			payment.setPaymentstatus(PaymentStatus.SUCCESS);
			paymentrepository.save(payment);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return CompletableFuture.completedFuture(null);
	}
	

}
