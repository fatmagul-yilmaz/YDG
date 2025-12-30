package com.example.AlisverisSitesi.business.abstracts;

import java.util.List;

import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.entities.concretes.Order;

public interface OrderService {

	Result createOrder(Order order);

	DataResult<List<Order>> getAll();

	DataResult<List<Order>> getOrdersByUserId(int userId);
}
