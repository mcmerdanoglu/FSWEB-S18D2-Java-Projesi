package FruitsAndVegetables.FruitsVegetables.dao;

import FruitsAndVegetables.FruitsVegetables.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    //@Query("SELECT f FROM fruit f ORDER BY f.price DESC") yazınca program çalışmadı.
    // Aşağıdaki gibi Fruit olarak Class ismi yazılmalı!!!
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")//JPQL
    List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")//JPQL
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> seachByName(String name);
}
