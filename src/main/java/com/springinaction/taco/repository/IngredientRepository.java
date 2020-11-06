package com.springinaction.taco.repository;

import com.springinaction.taco.dto.Ingredient;
import com.springinaction.taco.dto.Ingredient.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    List<Ingredient> findAllByType(Type type);
}
