package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Category_Master;
import com.etour.repositories.Category_MasterRepo;
import com.etour.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Category_MasterManagerImpl implements Category_MasterManager {


	@Autowired
	private Category_MasterRepo categoryrepository;
	@Override
	public void save(Category_Master ref) {
		// TODO Auto-generated method stub
		System.out.println("Add save");
		categoryrepository.save(ref);
	}

	@Override
	public List<Category_Master> getAll() {
		// TODO Auto-generated method stub
		return categoryrepository.findAll();
	}
	@Override
	public void delete(int id) {
		categoryrepository.deleteById(id);
	}
	@Override
	public void update(Category_Master category,int id) {
		// TODO Auto-generated method stub
		System.out.println("inside update method of service layer");
		categoryrepository.update(category.getCategoryid(),category.getSubcategoryid(),category.getCategoryname(),category.getCategoryimage(),category.isFlag(),id);
	}
	
	@Override
	public List<Category_Master> getSelected(String cat) {
		// TODO Auto-generated method stub
		return categoryrepository.listCat(cat);
	}
	@Override
	public Optional<Category_Master> getCategory(int id) {
		// TODO Auto-generated method stub
		return categoryrepository.findById(id);
	}
	
	@Override
	public List<Category_Master> getAllcat() {
		return categoryrepository.findData();
	}

	@Override
	public List<Category_Master> getSubcat(String id) {
		return categoryrepository.findSubcat(id);
	}

	
	
}
