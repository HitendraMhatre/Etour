package com.etour.services;

import java.util.List;

import com.etour.dto.SearchRequestdto;
import com.etour.dto.Searchdto;

public interface SearchManager 
{
	 List<?> search(SearchRequestdto request);

}
