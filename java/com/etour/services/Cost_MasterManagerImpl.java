package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.entities.Cost_Master;
import com.etour.repositories.Cost_MasterRepository;
@Service
public class Cost_MasterManagerImpl implements Cost_MasterManager {
	@Autowired
	private Cost_MasterRepository costrepository;
	
	public void save(Cost_Master ref){
		costrepository.save(ref);
	}
	public List<Cost_Master> getAll(){
		return costrepository.findAll();
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		costrepository.deleteById(id);
	}
	@Override
	public void update(Cost_Master cost, int id) {
		// TODO Auto-generated method stub
		costrepository.update(cost.getCost(), cost.getSinglepersoncost(), cost.getExtrapersoncost(), cost.getChildwithbed(), cost.getChildwithoutbed(), cost.getValidfrom(), cost.getValidto(), cost.getCosmasterid(), id);
	}
	@Override
	public Optional<Cost_Master> getCost(int id) {
		// TODO Auto-generated method stub
		return costrepository.findById(id);
	}
}
