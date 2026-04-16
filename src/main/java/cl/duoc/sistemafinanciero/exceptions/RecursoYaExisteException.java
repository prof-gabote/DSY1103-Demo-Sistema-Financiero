package cl.duoc.sistemafinanciero.exceptions;

public class RecursoYaExisteException extends RuntimeException {

    public RecursoYaExisteException(String mensaje) {
        super(mensaje);
    }
    
}
