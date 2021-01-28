package com.tp.diceroller.controllers;

import com.tp.diceroller.services.Rng;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }
    @GetMapping("/sixSides")
    public int sixSides() {
        return Rng.rollDice(6);
    }

    @GetMapping("/twentySides")
    public int twentySides() {
        return Rng.rollDice(20);
    }

    @GetMapping("/nSides")
    public int nSides(Integer n) {
        return Rng.rollDice(n);
    }

    @GetMapping("/nSides/{num}")
    public int nSidesPathVariable(@PathVariable Integer num) {
        return Rng.rollDice(num);
    }
}
