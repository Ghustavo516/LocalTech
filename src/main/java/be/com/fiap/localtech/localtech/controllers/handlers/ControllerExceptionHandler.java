package be.com.fiap.localtech.localtech.controllers.handlers;

import be.com.fiap.localtech.localtech.dtos.ResourceNotFoundDTO;
import be.com.fiap.localtech.localtech.dtos.ValidationErrorDTO;
import be.com.fiap.localtech.localtech.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDTO> handlerResourceNotFoundException(ResourceNotFoundException e){
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status.value()).body(new ResourceNotFoundDTO(e.getMessage(), status.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDTO> handlerMethodArgumentsNotValidException(MethodArgumentNotValidException e){
        var status = HttpStatus.BAD_REQUEST;
        List<String> errors = new ArrayList<String>();
        for(var error: e.getBindingResult().getFieldErrors()){
            errors.add(error.getField() + ":" + error.getDefaultMessage());
        }
        return ResponseEntity.status(status.value()).body(new ValidationErrorDTO(errors, status.value()));
    }
}
