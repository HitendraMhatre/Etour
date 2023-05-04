package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Cost_Master;
import com.etour.entities.Customer_Master;

public interface Customer_MasterManager {
	void save(Customer_Master ref);
	List<Customer_Master> getAll();
	void delete(int id);
	void update(Customer_Master customer,int id);
	Optional<Customer_Master> getCustomer(int id);
}
