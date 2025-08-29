package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Payments;
import com.example.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice;

	public static class PaymentRequest {
		public int dealerId;
		public double amount;
		public String method;
	}
	

	@PostMapping("/initiate")
	public ResponseEntity<?> initiatePayment(@RequestBody PaymentRequest request ){
		try {
			Payments payment = paymentservice.initiatePayment(request.dealerId, request.amount, request.method);
			return ResponseEntity.ok(payment);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
	
}
