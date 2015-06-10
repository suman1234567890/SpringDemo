package org.missionarogya.arogyacart.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="MyObject Not Found") //404
public class MyObjectNotFoundException extends Exception{
    private static final long serialVersionUID = -1L;
    
    public MyObjectNotFoundException(String id){
        super("MyOBjectNotFound with id="+id);
    } 
}
