package FruitsAndVegetables.FruitsVegetables.services;

import FruitsAndVegetables.FruitsVegetables.entity.Fruit;
import FruitsAndVegetables.FruitsVegetables.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    List<Vegetable> findAllByPriceAsc();

    List<Vegetable> findAllByPriceDesc();

    List<Vegetable> findByName(String name);

    Vegetable find(int id);

    Vegetable save(Vegetable vegetable);

    void delete(Vegetable vegetable);
}
