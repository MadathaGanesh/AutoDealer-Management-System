package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	@Query("SELECT v FROM Vehicle v WHERE v.dealer.subscriptiontype = com.example.entity.SubscriptionType.PREMIUM")
	public List<Vehicle> findPremiumVehicleDetails();

}
