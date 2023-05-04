package com.etour.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.dto.SearchRequestdto;
import com.etour.dto.Searchdto;
import com.etour.repositories.SearchRepository;

@Service
public class SearchManagerImpl implements SearchManager
{
	@Autowired
	SearchRepository repository;

	@Override
	public List<?> search(SearchRequestdto req) 
	{
		//List<Object[]> searchresult =repository.searchspec(request);
//		Object[] result = searchresult.get(0);
//		int masterid = (int) result[0];
//		String categoryname = (String) result[1];
//		Date departuredate = (Date)result[2];
//		Date endate =(Date)result[3];
//		double cost =(double)result[4];
		Date start_date = req.getStartdate();
		Date end_date = req.getEnddate();
		double max_cost = req.getMaxcost();
		int noof_days = req.getNoofdays();		
		List<Object[]> result = repository.searchspec(start_date, end_date, max_cost, noof_days);
		List<Searchdto> giveres = new ArrayList<>();

		for (Object[] event : result) {
		    double cost = (double) event[0];
		    Date startdate = ((Date) event[1]);
		    Date enddate = ((Date) event[2]);
		    int noofdays = (int) event[3];
		    int masterid = (int) event[4];
		    String categoryname = (String) event[5];

		    Searchdto response = new Searchdto(masterid, categoryname, startdate, enddate, noofdays, cost);
		    giveres.add(response);
		}

		 return giveres;
	}

}
