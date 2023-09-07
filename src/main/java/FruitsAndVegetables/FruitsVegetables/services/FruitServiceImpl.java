package FruitsAndVegetables.FruitsVegetables.services;

import FruitsAndVegetables.FruitsVegetables.dao.FruitRepository;
import FruitsAndVegetables.FruitsVegetables.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Böylelikle controller bu servisi çağırabilecek
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired //Böylelikle fruitrepository nesnesi veritabanına uygun şekilde oluştutulacak
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    /*
    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    } */

    @Override
    public List<Fruit> findAllByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override //Readmeye göre findAll() bu method;
    public List<Fruit> findAllByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> findByName(String name) {
        return fruitRepository.seachByName(name);
    }

    @Override
    public Fruit find(int id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void delete(Fruit fruit) {
        fruitRepository.delete(fruit);
    }


}
