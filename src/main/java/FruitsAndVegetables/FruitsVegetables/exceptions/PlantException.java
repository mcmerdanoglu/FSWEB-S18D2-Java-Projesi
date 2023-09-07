package FruitsAndVegetables.FruitsVegetables.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

// Exceptionları yönetmenin asıl amacı 500 hatası dönmemesi içindir.
// Hataları ehlileştirerek 500den 400e geçiririz ve anlamlı bilgiler alırız.
@Getter
@Setter
public class PlantException extends RuntimeException {
    private HttpStatus status;

    public PlantException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
