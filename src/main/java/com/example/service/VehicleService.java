package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Vehicle;
import com.example.repository.VehicleRepository;

@Service
public class VehicleService  {

	
	@Autowired
	private VehicleRepository vehicle_repository;

	
	public List<Vehicle> getAllVehicles(){
		return vehicle_repository.findAll();
	}
	
	public Optional<Vehicle> getVehicleByID(int vehicleID) {
		return vehicle_repository.findById(vehicleID);
	}
	
	
	public Vehicle AddNewVehicle(Vehicle newVehicle) {
		return vehicle_repository.save(newVehicle);
	}

	public void removeVehicle(int vehicleID) {
		vehicle_repository.deleteById(vehicleID);
	}
	
	public Vehicle updateVehicleDetails(int vehicleID, Vehicle updatedVehicleDetails) {
		return vehicle_repository.findById(vehicleID).map(vehicleDetails ->{
			vehicleDetails.setDealer(updatedVehicleDetails.getDealer());
			vehicleDetails.setModel(updatedVehicleDetails.getModel());
			vehicleDetails.setPrice(updatedVehicleDetails.getPrice());
			vehicleDetails.setStatus(updatedVehicleDetails.getStatus());
			return vehicle_repository.save(vehicleDetails);
		}).orElseThrow(()->new RuntimeException("No Vehicle Data found with this Vehicle ID : "+vehicleID));
	}
	
	
	public List<Vehicle> getPremiumVehicleDetails(){
		return vehicle_repository.findPremiumVehicleDetails();
	}
}




