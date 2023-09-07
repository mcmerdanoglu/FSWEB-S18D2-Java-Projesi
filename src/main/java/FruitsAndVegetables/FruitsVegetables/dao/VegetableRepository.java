package FruitsAndVegetables.FruitsVegetables.dao;

import FruitsAndVegetables.FruitsVegetables.entity.Fruit;
import FruitsAndVegetables.FruitsVegetables.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {
    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")//JPQL
    List<Vegetable> getByPriceDesc();

    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")//JPQL
    List<Vegetable> getByPriceAsc();

    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> seachByName(String name);

}
