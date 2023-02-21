package com.example.New.user.project.entity.exception;

import com.example.New.user.project.entity.controller.service.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.relation.RoleNotFoundException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    String handle (UserPrincipalNotFoundException ex) {
        return String.format(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleMethod (MethodArgumentNotValidException ex) {
        Map<String, String> handledErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError-> {
            handledErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return handledErrors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RoleNotFoundException.class)
    String handleRoleNotFoundException(RoleNotFoundException ex) {
        return String.format("Role does not exist.");

    }
}
