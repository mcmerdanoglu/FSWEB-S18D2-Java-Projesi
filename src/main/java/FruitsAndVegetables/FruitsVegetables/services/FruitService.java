package FruitsAndVegetables.FruitsVegetables.services;

import FruitsAndVegetables.FruitsVegetables.entity.Fruit;

import java.util.List;

public interface FruitService {

    /*
    List<Fruit> findAll();
    */

    List<Fruit> findAllByPriceDesc();

    //Readmeye göre findAll() bu method;
    List<Fruit> findAllByPriceAsc();

    List<Fruit> findByName(String name);

    Fruit find(int id);

    Fruit save(Fruit fruit);

    void delete(Fruit fruit);
}
