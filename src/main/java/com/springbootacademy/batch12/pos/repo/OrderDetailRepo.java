package com.springbootacademy.batch12.pos.repo;

import com.springbootacademy.batch12.pos.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetails,Integer> {
}
