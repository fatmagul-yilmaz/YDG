package com.example.AlisverisSitesi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.AlisverisSitesi.entities.concretes.Product;
import com.example.AlisverisSitesi.entities.dtos.ProductWithCategoryDto;


public interface ProductDao extends JpaRepository<Product, Integer> {

	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	
	//Konteyner oluşturduk.
	List<Product> getByProductNameContains (String productName);

	List<Product> getByProductNameStartsWith (String productName);

	
	//Burada veritabanından bağımsız işlem yaparız sanki veritabanı Product class ıymış gibi işlem yap.
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	

	// Buraya package nameyi çekmek zorundayız.
	//New yazmayı unutma
	@Query ("Select new com.example.AlisverisSitesi.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List <ProductWithCategoryDto> getProducWithCategorytDetails ();
	
}
