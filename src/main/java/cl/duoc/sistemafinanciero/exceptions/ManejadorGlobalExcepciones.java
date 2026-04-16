package cl.duoc.sistemafinanciero.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    //Debes implementar métodos para manejar diferentes tipos de excepciones, como RecursoNoEncontradoException, IllegalArgumentException, etc.

    @ExceptionHandler()
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }

    //Crea una clase interna de respuesta personalizada para manejar errores de validación, si es necesario

}
