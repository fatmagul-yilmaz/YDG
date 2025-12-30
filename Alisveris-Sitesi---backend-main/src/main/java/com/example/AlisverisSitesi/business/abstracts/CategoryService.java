package com.example.AlisverisSitesi.business.abstracts;

import java.util.List;

import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.entities.concretes.Category;

public interface CategoryService {

	DataResult<List<Category>> getAll();
	
	DataResult<Category> getById(int id);
	
	Result add(Category category);
	
	Result update(Category category);
	
	Result delete(int id);
}

