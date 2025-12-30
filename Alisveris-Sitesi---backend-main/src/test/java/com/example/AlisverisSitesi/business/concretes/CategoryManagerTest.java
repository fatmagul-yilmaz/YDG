package com.example.AlisverisSitesi.business.concretes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.AlisverisSitesi.dataAccess.abstracts.CategoryDao;
import com.example.AlisverisSitesi.entities.concretes.Category;

@ExtendWith(MockitoExtension.class)
public class CategoryManagerTest {

    @Mock
    private CategoryDao categoryDao;

    @InjectMocks
    private CategoryManager categoryManager;

    @Test
    void getAll_shouldReturnCategoryList() {

        // arrange
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(new Category());

        when(categoryDao.findAll()).thenReturn(mockCategories);

        // act
        var result = categoryManager.getAll();

        // assert
        verify(categoryDao).findAll();
        assertEquals(1, result.getData().size());
    }

    @Test
    void add_shouldSaveCategory() {

        // arrange
        Category category = new Category();
        category.setCategoryName("Elektronik");

        // act
        categoryManager.add(category);

        // assert
        verify(categoryDao).save(category);
    }
}
