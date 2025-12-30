package com.example.AlisverisSitesi.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.AlisverisSitesi.business.abstracts.ProductService;
import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.core.utilities.results.SuccessDataResult;
import com.example.AlisverisSitesi.core.utilities.results.SuccessResult;
import com.example.AlisverisSitesi.dataAccess.abstracts.ProductDao;
import com.example.AlisverisSitesi.entities.concretes.Product;
import com.example.AlisverisSitesi.entities.dtos.ProductWithCategoryDto;


@Service
public class ProductManager implements ProductService {

	// Injection işlemi yapıldı.
	private final ProductDao productDao ;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"Ürünler listelendi.");
				
	}


	@Override
	public Result add(Product product) {
	   this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Ürünler listelendi.");
				
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Ürünler listelendi.");
				
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Ürünler listelendi.");
				
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {

		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategory_CategoryIdIn(categories),"Ürünler listelendi.");
				
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {

		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Ürünler listelendi.");
				
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Ürünler listelendi.");
				
	}



	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
	return new SuccessDataResult<List<Product>>
	(this.productDao.getByNameAndCategory(productName, categoryId),"Ürünler listelendi.");	


}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Product>> 
		(this.productDao.findAll(pageable).getContent());
	}


	@Override
	//unitPrice yazan yere istediğini yazabilirsin.
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "unitPrice");
		return new SuccessDataResult<List<Product>> 
		(this.productDao.findAll(sort), "İşlem başarılı");
	}


	@Override
	public DataResult<List<ProductWithCategoryDto>> getProducWithCategorytDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProducWithCategorytDetails(),"Ürünler listelendi.");
		
	}
	}




