package org.missionarogya.arogyacart.exception.advice;
import org.missionarogya.arogyacart.controller.object.MyObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@ControllerAdvice(annotations=RestController.class)
public class MyObjectExceptionAdvice {
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ExceptionHandler(SQLException.class)
    public MyObjectException handleSQLException(SQLException exception){
      MyObjectException customException = new MyObjectException();
      customException.setMessage(exception.getMessage());
      return customException; 
    }
     
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ExceptionHandler(IOException.class)
    public MyObjectException handleIOException(IOException exception){
       MyObjectException customException = new MyObjectException();
      customException.setMessage(exception.getMessage());
      return customException;
    }
}
