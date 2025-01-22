package com.springbootacademy.batch12.pos.repo;


import com.springbootacademy.batch12.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByActiveStateEquals(boolean activeState);


}
