package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Vehicle;
import com.example.service.VehicleService;


@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleservice;

	@GetMapping("/allvehicledetails")
	public List<Vehicle> getAllVehicleDetails(){
		return vehicleservice.getAllVehicles();
	}
	
	@GetMapping("/getvehiclebyID")
	public Optional<Vehicle> getVehicleByID(@PathVariable int vehicleID) {
		return vehicleservice.getVehicleByID(vehicleID);
	}
	
	@PostMapping("/addnewVehicle")
	public Vehicle AddNewVehicle(@RequestBody Vehicle newVehicleDetails) {
		return vehicleservice.AddNewVehicle(newVehicleDetails);
	}
	
	@PutMapping("/updatevehicleDetails/{vehicleID}")
	public Vehicle updateVehicleDetails(@PathVariable int vehicleID, @RequestBody Vehicle updatedVehicleDetails) {
		return vehicleservice.updateVehicleDetails(vehicleID, updatedVehicleDetails);
	}
	
	@DeleteMapping("/deletevehiclebyID/{vehicleID}")
	public void removeVehicle(@PathVariable int vehicleID) {
		 vehicleservice.removeVehicle(vehicleID);
	}
	
	@GetMapping("/getPremiumVehicleDetails")
	public List<Vehicle> getPremiumVehicleDetails(){
		return vehicleservice.getPremiumVehicleDetails();
	}
	
	
}
