package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Dealer;
import com.example.repository.DealerRepository;

@Service
public class DealerService {


	@Autowired
	private DealerRepository dealer_repository;


	public Dealer AddNewDealer(Dealer new_dealer_details) {
		return dealer_repository.save(new_dealer_details);
	}
	
	public List<Dealer> getAllDealers(){
		return dealer_repository.findAll();
	}
	
	public Optional<Dealer> getDealerByID(int dealerID) {
		return dealer_repository.findById(dealerID);
	}
	
	
	public Dealer UpdateDealerData(int dealerID, Dealer updated_Dealer_Details) {
		return dealer_repository.findById(dealerID).map(updated_dealer ->{
			updated_dealer.setEmail(updated_Dealer_Details.getEmail());
			updated_dealer.setName(updated_Dealer_Details.getName());
			updated_dealer.setSubscriptiontype(updated_Dealer_Details.getSubscriptiontype());
			return dealer_repository.save(updated_dealer);
		}).orElseThrow(()-> new RuntimeException("No Dealer found with this Dealer ID : "+ dealerID));		
	}
	
	
	public void removeDealer(int dealerID) {
		 dealer_repository.deleteById(dealerID);
	}
	
}
