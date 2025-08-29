package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int vehicleID;
				
		private String Model;
				
		private long price;
		
		@Enumerated(EnumType.STRING)
		@Column(nullable = false)
		private Status status;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="DealerID",nullable = false)
		private Dealer dealer;
		
		public Vehicle() {
		}

		public Vehicle(int vehicleID, String model, long price, Status status, Dealer dealer) {
			this.vehicleID = vehicleID;
			Model = model;
			this.price = price;
			this.status = status;
			this.dealer = dealer;
		}

		public int getVehicleID() {
			return vehicleID;
		}

		public void setVehicleID(int vehicleID) {
			this.vehicleID = vehicleID;
		}

		public String getModel() {
			return Model;
		}

		public void setModel(String model) {
			Model = model;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public Dealer getDealer() {
			return dealer;
		}

		public void setDealer(Dealer dealer) {
			this.dealer = dealer;
		}  
		
}



