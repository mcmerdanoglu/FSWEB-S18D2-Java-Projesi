package FruitsAndVegetables.FruitsVegetables.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass //Bu annotation ile Hibernate bu classın DBde tablosu olmayacağını ama fieldlarının başka tablolarca kullanılacağını bilir.
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    @Size (min=2, max=45, message = "Must be between 2 and 45")
    private String name;

    @Column(name = "price")
    @DecimalMin("9")
    private double price;
}
