package FruitsAndVegetables.FruitsVegetables.controller;

import FruitsAndVegetables.FruitsVegetables.entity.Fruit;
import FruitsAndVegetables.FruitsVegetables.exceptions.PlantException;
import FruitsAndVegetables.FruitsVegetables.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
@Validated
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> getAllFruits() {
        return fruitService.findAllByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getFruitById(@Positive @PathVariable int id) {
        Fruit fruit = fruitService.find(id);
        if (fruit == null) {
            throw new PlantException("Fruit with given id " + id + " does not exist", HttpStatus.NOT_FOUND);
        }
        return fruit;
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitsByPriceDesc() {
        return fruitService.findAllByPriceDesc();
    }

    @GetMapping("/search/{name}")
    public List<Fruit> getFruitsByName(@PathVariable String name) {
        return fruitService.findByName(name);
    }

    @PostMapping("/")//fruitte id varsa update olarak çalışır, yoksa create olarak çalışır ve yeni bir fruit ekler.
    public Fruit addOrUpdateFruit(@Validated @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit deleteFruit(@PathVariable int id) {
        Fruit fruitToDelete = getFruitById(id);
        fruitService.delete(fruitToDelete);
        return fruitToDelete;
    }
}


