package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.entities.Date_Master;
import com.etour.repositories.Date_MasterRepository;


@Service
public class Date_MasterManagerImpl implements Date_MasterManager {
	@Autowired
	private Date_MasterRepository daterepository;
public void save(Date_Master ref){
	daterepository.save(ref);
	}
	public List<Date_Master> getAll(){
		return daterepository.findAll();
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		daterepository.deleteById(id);
	}
	@Override
	public void update(Date_Master date, int id) {
		// TODO Auto-generated method stub
		daterepository.update(date.getDeparturedate(), date.getEnddate(), date.getNoofdays(), date.getDamasterid(), id);
	}
	@Override
	public Optional<Date_Master> getDate(int id) {
		// TODO Auto-generated method stub
		return daterepository.findById(id);
	}
}
