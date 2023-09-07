package FruitsAndVegetables.FruitsVegetables.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fruit", schema = "springjpa")
public class Fruit extends Plant{

    @Enumerated(EnumType.STRING)
    @Column(name="fruit_type")
    private FruitType fruitType;
}
