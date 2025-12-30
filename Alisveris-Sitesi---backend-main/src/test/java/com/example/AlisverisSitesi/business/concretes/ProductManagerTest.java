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

import com.example.AlisverisSitesi.dataAccess.abstracts.ProductDao;
import com.example.AlisverisSitesi.entities.concretes.Product;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductManager productManager;

    @Test
    void getAll_shouldReturnProductList() {

        // arrange
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product());

        when(productDao.findAll()).thenReturn(mockProducts);

        // act
        var result = productManager.getAll();

        // assert
        verify(productDao).findAll();
        assertEquals(1, result.getData().size());
    }

    @Test
    void add_shouldSaveProduct() {

        // arrange
        Product product = new Product();
        product.setProductName("Telefon");

        // act
        productManager.add(product);

        // assert
        verify(productDao).save(product);
    }
}
