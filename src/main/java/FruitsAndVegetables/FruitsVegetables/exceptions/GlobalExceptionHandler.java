package FruitsAndVegetables.FruitsVegetables.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler //Bizim hatalar
    public ResponseEntity<PlantResponse> handleException(PlantException plantException){
        PlantResponse plantResponse = new PlantResponse(plantException.getStatus().value(),
                plantException.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(plantResponse, plantException.getStatus());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class) //Annotation ile entityler üzerindeki hatalar
    public ResponseEntity handleBindErrors(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String, String> errors= new HashMap<>();
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errors;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }

    @ExceptionHandler //Global hatalar(Bizim dışımızdakiler)
    public ResponseEntity<PlantResponse> handleException(Exception exception){
        PlantResponse plantResponse = new PlantResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(plantResponse, HttpStatus.BAD_REQUEST);
    }
}
