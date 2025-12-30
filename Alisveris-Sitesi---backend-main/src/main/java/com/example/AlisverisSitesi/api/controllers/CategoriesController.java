package com.example.AlisverisSitesi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AlisverisSitesi.business.abstracts.CategoryService;
import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.entities.concretes.Category;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoriesController {

	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/getall")
	public DataResult<List<Category>> getAll() {
		return categoryService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Category> getById(@RequestParam int id) {
		return categoryService.getById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Category category) {
		return categoryService.add(category);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Category category) {
		return categoryService.update(category);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return categoryService.delete(id);
	}
}

