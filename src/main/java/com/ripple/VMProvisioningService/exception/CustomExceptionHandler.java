package com.ripple.VMProvisioningService.exception;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.service.ResponseStatusConstants;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleAppUserNotFoundException(ResourceNotFoundException ex) {
        ResponseData responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), ResponseStatusConstants.ERROR.name(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleSQLException(SQLException ex) {
        ResponseData responseData = new ResponseData(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatusConstants.ERROR.name(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
    }

    @ExceptionHandler(UnknownExecutionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleUnknownException(SQLException ex) {
        ResponseData responseData = new ResponseData(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatusConstants.ERROR.name(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
    }
















}
