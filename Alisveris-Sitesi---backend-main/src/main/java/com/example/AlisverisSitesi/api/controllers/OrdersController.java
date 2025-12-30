package com.example.AlisverisSitesi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AlisverisSitesi.business.abstracts.OrderService;
import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.entities.concretes.Order;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrdersController {

	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/create")
	public Result create(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	@GetMapping("/getall")
	public DataResult<List<Order>> getAll() {
		return orderService.getAll();
	}

	@GetMapping("/getbyuser")
	public DataResult<List<Order>> getByUser(@RequestParam int userId) {
		return orderService.getOrdersByUserId(userId);
	}
}
