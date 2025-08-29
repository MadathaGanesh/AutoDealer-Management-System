package com.example.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Dealer;
import com.example.service.DealerService;

@RestController
public class DealerController {
	
	@Autowired
	private DealerService dealerService;
	
	@PostMapping("/savedealerdata")
	public Dealer AddnewDealer(@RequestBody Dealer dealerData) {
		return dealerService.AddNewDealer(dealerData);
	}
	
	@GetMapping("/getalldealers")
	public List<Dealer> getAllDealers(){
		return dealerService.getAllDealers();
	}
	
	@GetMapping("/getdealerByID/{dealerID}")
	public Optional<Dealer> getDealerByID(@PathVariable int dealerID) {
		return dealerService.getDealerByID(dealerID);
	}
	
	@DeleteMapping("/removeDealer/{dealerId}")
	public void removeDealer(@PathVariable int dealerId) {
		 dealerService.removeDealer(dealerId);
	}
	
	
	@PutMapping("/updateDealerData/{dealerID}")
	public Dealer UpdateDealerData(@RequestBody Dealer updatedDealerData,@PathVariable int dealerID) {
		return dealerService.UpdateDealerData(dealerID, updatedDealerData);
	}
}


