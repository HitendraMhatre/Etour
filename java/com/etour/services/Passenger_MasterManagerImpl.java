package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.entities.Passenger_Master;
import com.etour.repositories.Passenger_MasterRepo;

@Service
public class Passenger_MasterManagerImpl implements Passenger_MasterManager {

	
	
	@Autowired
	private Passenger_MasterRepo repository;
	
	
	@Override
	public void save(Passenger_Master ref) {
		// TODO Auto-generated method stub
		repository.save(ref);
	}

	@Override
	public List<Passenger_Master> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stubr
		repository.deleteById(id);
	}

	@Override
	public void update(Passenger_Master passenger, int id) {
		// TODO Auto-generated method stub
		repository.update(passenger.getPaxname(),passenger.getPaxbirthdate(),passenger.getPaxtype(),  passenger.getAmount(), passenger.getPasscustomerid(), passenger.getPassbookingid(), id);
	}

	@Override
	public Optional<Passenger_Master> getPassenger(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	



	


}
