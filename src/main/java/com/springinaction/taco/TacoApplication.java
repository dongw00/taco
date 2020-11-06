package com.springinaction.taco;

import com.springinaction.taco.dto.Ingredient;
import com.springinaction.taco.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

import static com.springinaction.taco.dto.Ingredient.Type.*;

@SpringBootApplication
public class TacoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository) {
        return args -> {
            List<Ingredient> ingredients = Arrays.asList(
                    new Ingredient("FLTO", "Flour Tortilla", WRAP),
                    new Ingredient("COTO", "Corn Tortilla", WRAP),
                    new Ingredient("GRBF", "Ground Beef", PROTEIN),
                    new Ingredient("CARN", "Carnitas", PROTEIN),
                    new Ingredient("TMTO", "Diced Tomatoes", VEGGIES),
                    new Ingredient("LETC", "Lettuce", VEGGIES),
                    new Ingredient("CHED", "Cheddar", CHEESE),
                    new Ingredient("JACK", "Monterray Jack", CHEESE),
                    new Ingredient("SLSA", "Salsa", SAUCE),
                    new Ingredient("SRCR", "Sour Cream", SAUCE));
            repository.saveAll(ingredients);
        };
    }
}
