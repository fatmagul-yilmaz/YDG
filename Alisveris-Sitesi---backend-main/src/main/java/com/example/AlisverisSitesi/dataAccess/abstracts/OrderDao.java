package com.example.AlisverisSitesi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AlisverisSitesi.entities.concretes.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

	List<Order> findByUser_Id(int userId);
}
