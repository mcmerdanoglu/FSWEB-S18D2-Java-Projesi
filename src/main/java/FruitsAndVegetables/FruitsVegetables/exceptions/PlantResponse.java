package FruitsAndVegetables.FruitsVegetables.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlantResponse {
    private int status;
    private String message;
    private long timestamp;

}
