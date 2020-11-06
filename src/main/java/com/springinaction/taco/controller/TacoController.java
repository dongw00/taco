package com.springinaction.taco.controller;

import com.springinaction.taco.dto.Ingredient;
import com.springinaction.taco.dto.Ingredient.Type;
import com.springinaction.taco.dto.Taco;
import com.springinaction.taco.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@RequiredArgsConstructor
public class TacoController {

    private final IngredientRepository ingredientRepository;

    @GetMapping
    public String showDesign(Model model) {
        for (Type type : Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientRepository.findAllByType(type), type));
        }
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(Taco taco) {
        log.info("Processing Taco = " + taco.toString());
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
