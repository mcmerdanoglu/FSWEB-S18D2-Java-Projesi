package FruitsAndVegetables.FruitsVegetables.services;

import FruitsAndVegetables.FruitsVegetables.dao.FruitRepository;
import FruitsAndVegetables.FruitsVegetables.dao.VegetableRepository;
import FruitsAndVegetables.FruitsVegetables.entity.Fruit;
import FruitsAndVegetables.FruitsVegetables.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Böylelikle controller bu servisi çağırabilecek
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;

    @Autowired //Böylelikle vegetableRepository nesnesi veritabanına uygun şekilde oluştutulacak
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAllByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override //Readmeye göre findAll() bu method;
    public List<Vegetable> findAllByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetableRepository.seachByName(name);
    }

    @Override
    public Vegetable find(int id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if (vegetableOptional.isPresent()) {
            return vegetableOptional.get();
        }
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Vegetable vegetable) {
        vegetableRepository.delete(vegetable);
    }

}
