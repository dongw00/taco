package com.springinaction.taco.repository;

import com.springinaction.taco.dto.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
