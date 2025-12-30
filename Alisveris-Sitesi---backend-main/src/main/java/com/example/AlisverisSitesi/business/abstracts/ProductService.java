package com.example.AlisverisSitesi.business.abstracts;

import java.util.List;


import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.entities.concretes.Product;
import com.example.AlisverisSitesi.entities.dtos.ProductWithCategoryDto;


public interface ProductService {

	// Ürünlerin tamamını getirir.
   DataResult<List<Product>> getAll();
   
   DataResult<List<Product>> getAll(int pageNo, int pageSize); 
   
   DataResult<List<Product>> getAllSorted();
   
   Result add(Product product);

   DataResult<Product> getByProductName(String productName);
	
   DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
   DataResult<List<Product>>getByProductNameOrCategoryId(String productName, int categoryId);

   DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
	//Konteyner oluşturduk
   DataResult<List<Product>> getByProductNameContains (String productName);

   DataResult<List<Product>> getByProductNameStartsWith (String productName);

   DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
   
   DataResult<List <ProductWithCategoryDto>>getProducWithCategorytDetails ();
   
   
 }

   
	

