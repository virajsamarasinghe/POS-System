package com.springbootacademy.batch12.pos.repo;

import com.springbootacademy.batch12.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
