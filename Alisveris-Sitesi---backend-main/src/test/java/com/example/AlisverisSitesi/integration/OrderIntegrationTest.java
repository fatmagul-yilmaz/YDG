package com.example.AlisverisSitesi.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.AlisverisSitesi.business.concretes.OrderManager;
import com.example.AlisverisSitesi.entities.concretes.Order;
import com.example.AlisverisSitesi.entities.concretes.OrderItem;
import com.example.AlisverisSitesi.entities.concretes.Product;
import com.example.AlisverisSitesi.core.entities.User;
import com.example.AlisverisSitesi.dataAccess.abstracts.ProductDao;

@SpringBootTest
@ActiveProfiles("test")
class OrderIntegrationTest {

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private ProductDao productDao;

    
    @Test
    void shouldCreateOrderAndCalculateTotalPrice() {

        User user = new User();
        user.setId(1);

        Product product = new Product();
        product.setProductName("Telefon");
        product.setUnitPrice(100);

        product = productDao.save(product);
        
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(2);
        item.setUnitPrice(100);

        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(List.of(item));

        orderManager.createOrder(order);

        assertEquals(200, order.getTotalPrice());
        assertEquals("CREATED", order.getStatus());
    }
}
