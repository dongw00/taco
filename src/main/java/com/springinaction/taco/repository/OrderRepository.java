package com.springinaction.taco.repository;

import com.springinaction.taco.dto.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
