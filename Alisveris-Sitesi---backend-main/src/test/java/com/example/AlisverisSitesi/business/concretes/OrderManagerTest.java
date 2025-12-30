package com.example.AlisverisSitesi.business.concretes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.AlisverisSitesi.dataAccess.abstracts.OrderDao;
import com.example.AlisverisSitesi.entities.concretes.Order;
import com.example.AlisverisSitesi.entities.concretes.OrderItem;
import com.example.AlisverisSitesi.entities.concretes.Product;
import com.example.AlisverisSitesi.core.entities.User;

@ExtendWith(MockitoExtension.class)
public class OrderManagerTest {

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderManager orderManager;

    private Order order;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setId(1);

        Product product = new Product();
        product.setId(5);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(2);
        orderItem.setUnitPrice(100);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);

        order = new Order();
        order.setUser(user);
        order.setOrderItems(orderItems);
    }

    @Test
    void createOrder_shouldCalculateTotalPrice_andSaveOrder() {

        // act
        orderManager.createOrder(order);

        // assert
        assertEquals(200, order.getTotalPrice());
        assertEquals("CREATED", order.getStatus());

        verify(orderDao).save(order);
    }
}
