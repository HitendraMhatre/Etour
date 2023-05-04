package com.etour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.SearchRequestdto;
import com.etour.services.SearchManager;

@RestController
@CrossOrigin("http://localhost:3000")
public class SearchController 
{
	@Autowired
	SearchManager manager;
	
	@PostMapping(value="/api/search")
	public List<?> getresult(@RequestBody SearchRequestdto req)
	{
		return manager.search(req);
	}

}
