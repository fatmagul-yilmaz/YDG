package com.example.AlisverisSitesi.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AlisverisSitesi.business.abstracts.CategoryService;
import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.core.utilities.results.SuccessDataResult;
import com.example.AlisverisSitesi.core.utilities.results.SuccessResult;
import com.example.AlisverisSitesi.dataAccess.abstracts.CategoryDao;
import com.example.AlisverisSitesi.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {

	private CategoryDao categoryDao;

	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>(categoryDao.findAll(), "Kategoriler listelendi");
	}

	@Override
	public DataResult<Category> getById(int id) {
		return new SuccessDataResult<Category>(categoryDao.findById(id).orElse(null));
	}

	@Override
	public Result add(Category category) {
		categoryDao.save(category);
		return new SuccessResult("Kategori eklendi");
	}

	@Override
	public Result update(Category category) {
		categoryDao.save(category);
		return new SuccessResult("Kategori güncellendi");
	}

	@Override
	public Result delete(int id) {
		categoryDao.deleteById(id);
		return new SuccessResult("Kategori silindi");
	}
}

