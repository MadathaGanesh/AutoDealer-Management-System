package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Dealer")
public class Dealer {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int DealerID;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true , nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private SubscriptionType subscriptiontype;

	@OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles;
	
	public Dealer(int dealerID, String name, String email, SubscriptionType subscriptiontype, List<Vehicle> vehicles) {
		DealerID = dealerID;
		this.name = name;
		this.email = email;
		this.subscriptiontype = subscriptiontype;
		this.vehicles = vehicles;
	}

	public Dealer() {
	}

	public int getDealerID() {
		return DealerID;
	}

	public void setDealerID(int DealerID) {
		this.DealerID = DealerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SubscriptionType getSubscriptiontype() {
		return subscriptiontype;
	}

	public void setSubscriptiontype(SubscriptionType subscriptiontype) {
		this.subscriptiontype = subscriptiontype;
	}

}


