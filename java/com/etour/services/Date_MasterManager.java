package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Cost_Master;
import com.etour.entities.Date_Master;

public interface Date_MasterManager {
	void save(Date_Master ref);
	List<Date_Master> getAll();
	void delete(int id);
	void update(Date_Master date,int id);
	Optional<Date_Master> getDate(int id);
}
