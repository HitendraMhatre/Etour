package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Category_Master;

public interface Category_MasterManager {

	void save(Category_Master ref);
	void delete(int id);
	void update(Category_Master category,int id);
	public List<Category_Master> getSelected(String cat);
	public Optional<Category_Master> getCategory(int id);
	List<Category_Master> getAll();
	 List<Category_Master> getSubcat(String id);
	 List<Category_Master> getAllcat();
	
	
}
