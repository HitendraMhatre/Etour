package com.etour.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.dto.ItineraryDto;
import com.etour.entities.Date_Master;
import com.etour.entities.Itinerary_Master;
import com.etour.repositories.Itinerary_MasterRepo;

@Service
public class Itinerary_MasterManagerImpl implements Itinerary_MasterManager {
	
	
	@Autowired
	Itinerary_MasterRepo repository;	
	
	@Override
	public void save(Itinerary_Master ref) {
		// TODO Auto-generated method stub
		repository.save(ref);
	}

	@Override
	public List<Itinerary_Master> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void update(Itinerary_Master itinerary, int id) {
		// TODO Auto-generated method stub
		repository.update(itinerary.getTourduration(), itinerary.getItrdetail(), itinerary.getItimasterid(), id);
	}

	@Override
	public Optional<Itinerary_Master> getItinerary(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	
	
	
	@Override
	public List<ItineraryDto> findItineraryById(Integer id) {
		
		      List<Object[]> obj   =  repository.findItineraryById(id);
		      
		      Object []arr=obj.get(0);
		      System.out.println("departure id"+arr[4]);
		      int itrid= (int)arr[0];
		      int itimasterid=(int)arr[1];
		      String itrdetail= (String)arr[2];
		      int tourduration=(int)arr[3];
		      int departureid =(int)arr[4];
		      int damasterid=(int)arr[5];
		      Date departuredate=(Date)arr[6];
		      Date enddate = (Date)arr[7];
		      int noofdays= (int)arr[8];
		      double singlepersoncost= (double)arr[9];
		      double extrapersoncost = (double)arr[10]; 
		      double childwithbed = (double)arr[11];
		      double childwithoutbed = (double)arr[12];
		      Date validfrom  = (Date)arr[13];
		      Date validto = (Date)arr[14];
		      String categoryname = (String)arr[15];
		      String categoryimage = (String)arr[16];
		      
		      
		      Itinerary_Master itr = new Itinerary_Master(tourduration,itrdetail,itimasterid );
		      itr.setItrid(itrid);
		      Date_Master dm = new Date_Master(departuredate,enddate,noofdays,damasterid);
		      dm.setDepartureid(departureid);
		      ItineraryDto dto = new ItineraryDto(itr, dm, singlepersoncost, extrapersoncost,childwithbed,childwithoutbed, validfrom, validto, categoryname, categoryimage);
		      
		      List <ItineraryDto> ref =  new ArrayList<>();
		      ref.add(dto);
		      return ref;	      
    }

	

}
