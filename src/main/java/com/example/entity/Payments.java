package com.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentID;
	
	private int DealerID;
	
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentmethod;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentstatus;
	
	private LocalDateTime paymentTime;
	
	public Payments() {}

	public Payments( int dealerID, double amount, PaymentMethod paymentmethod,
			PaymentStatus paymentstatus, LocalDateTime paymentTime) {
		DealerID = dealerID;
		this.amount = amount;
		this.paymentmethod = paymentmethod;
		this.paymentstatus = paymentstatus;
		this.paymentTime = paymentTime;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public int getDealerID() {
		return DealerID;
	}

	public void setDealerID(int dealerID) {
		DealerID = dealerID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(PaymentMethod paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public PaymentStatus getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(PaymentStatus paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}
	
}
