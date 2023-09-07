package FruitsAndVegetables.FruitsVegetables.controller;

import FruitsAndVegetables.FruitsVegetables.entity.Fruit;
import FruitsAndVegetables.FruitsVegetables.entity.Vegetable;
import FruitsAndVegetables.FruitsVegetables.exceptions.PlantException;
import FruitsAndVegetables.FruitsVegetables.services.FruitService;
import FruitsAndVegetables.FruitsVegetables.services.VegetableService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
@Validated
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> getAllVegetables() {
        return vegetableService.findAllByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@Positive @PathVariable int id) {
        Vegetable vegetable = vegetableService.find(id);
        if (vegetable == null) {
            throw new PlantException("Vegetable with given id " + id + " does not exist", HttpStatus.NOT_FOUND);
        }
        return vegetable;
    }

    @GetMapping("/desc")
    public List<Vegetable> getVegetablesByPriceDesc() {
        return vegetableService.findAllByPriceDesc();
    }

    @GetMapping("/search/{name}")
    public List<Vegetable> getVegetablesByName(@PathVariable String name) {
        return vegetableService.findByName(name);
    }

    @PostMapping("/")//vegetableda id varsa update olarak çalışır, yoksa create olarak çalışır ve yeni bir vegetable ekler.
    public Vegetable addOrUpdateVegetable(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable deleteVegetable(@PathVariable int id) {
        Vegetable vegetableToDelete = getVegetableById(id);
        vegetableService.delete(vegetableToDelete);
        return vegetableToDelete;
    }
}


