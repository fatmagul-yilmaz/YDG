package com.example.AlisverisSitesi.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AlisverisSitesi.business.abstracts.OrderService;
import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.core.utilities.results.SuccessDataResult;
import com.example.AlisverisSitesi.core.utilities.results.SuccessResult;
import com.example.AlisverisSitesi.dataAccess.abstracts.OrderDao;
import com.example.AlisverisSitesi.entities.concretes.Order;
import com.example.AlisverisSitesi.entities.concretes.OrderItem;

@Service
public class OrderManager implements OrderService {

	private final OrderDao orderDao;

	@Autowired
	public OrderManager(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	@Transactional
	public Result createOrder(Order order) {

		// 🔴 Güvenlik: orderItems null veya boş olamaz
		if (order.getOrderItems() == null || order.getOrderItems().isEmpty()) {
			throw new RuntimeException("Sipariş en az bir ürün içermelidir");
		}

		double totalPrice = 0;

		for (OrderItem item : order.getOrderItems()) {
			// 🔗 ilişkiyi kur
			item.setOrder(order);

			// 🧮 toplam fiyat hesapla
			totalPrice += item.getUnitPrice() * item.getQuantity();
		}

		// 📌 Order alanları backend’de set edilir
		order.setTotalPrice(totalPrice);
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("CREATED");

		orderDao.save(order);

		return new SuccessResult("Sipariş başarıyla oluşturuldu");
	}

	@Override
	public DataResult<List<Order>> getAll() {
		return new SuccessDataResult<>(
				orderDao.findAll(),
				"Siparişler listelendi"
		);
	}

	@Override
	public DataResult<List<Order>> getOrdersByUserId(int userId) {
		return new SuccessDataResult<>(
				orderDao.findByUser_Id(userId),
				"Kullanıcıya ait siparişler listelendi"
		);
	}
}
