package org.missionarogya.arogyacart.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.missionarogya.arogyacart.controller.object.MessageResponseType;
import org.missionarogya.arogyacart.controller.object.MyObjectException;
import org.missionarogya.arogyacart.exception.custom.MyObjectNotFoundException;
import org.missionarogya.arogyacart.model.service.MyObjectService;
import org.missionarogya.arogyacart.model.dao.object.MyObject;
import org.springframework.http.HttpStatus;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;
import java.util.ArrayList;
import java.util.List;
@Api(value = "/spring", description = "sample swagger api") // Swagger annotation
@RequestMapping("/spring")
@RestController
public class SampleController extends AbstractController{
  
   @ApiOperation(value = "/put/{name}", notes = "Insert", response = MessageResponseType.class)
	@ApiResponses(value = {
  		@ApiResponse(code = 400, message = "Invalid ID supplied"),
  		@ApiResponse(code = 404, message = "Pet not found") 
	})
    @RequestMapping( value="/put/{name}",method=RequestMethod.GET)
    public MessageResponseType put(@PathVariable String name) {
      MyObjectService service = (MyObjectService) getContext().getBean("myObjectService");
      MyObject object = new MyObject();
      object.setId((int)(Math.random()*500));
      object.setName(name);
      service.saveObject(object);
      closeContext();
      return null;
      
    }
    @ApiOperation(value = "/find", notes = "Search", response = MessageResponseType.class)
	@ApiResponses(value = {
  		@ApiResponse(code = 400, message = "Invalid ID supplied"),
  		@ApiResponse(code = 404, message = "Pet not found") 
	})
  
    @RequestMapping(value="/find",method=RequestMethod.GET)
    public List<MessageResponseType> showAll() {
      MyObjectService service = (MyObjectService) getContext().getBean("myObjectService");
      List<MessageResponseType> messages = new ArrayList<MessageResponseType>();
      MessageResponseType message= null;
      List<MyObject> myObjects = service.findAllObjects();
      for(MyObject obj : myObjects){
        message = new MessageResponseType();
        message.setText(obj.getName());
        message.setId(String.valueOf(obj.getId()));
        messages.add(message);
      }
      closeContext();
      return messages;
    }
    @ApiOperation(value = "/find/{keyId}", notes = "Search By Id", response = MessageResponseType.class)
	 @ApiResponses(value = {
  		@ApiResponse(code = 400, message = "Invalid ID supplied"),
  		@ApiResponse(code = 404, message = "Pet not found") 
	})
    @RequestMapping(value="/find/{keyId}",method=RequestMethod.GET)
    public MessageResponseType search(@PathVariable String keyId)  throws MyObjectNotFoundException  {
      MyObjectService service = (MyObjectService) getContext().getBean("myObjectService");
      System.out.print("Id" +keyId);
      MyObject myObject = service.findBySsn(keyId);
      MessageResponseType message =null;
      if(myObject != null){
      	message = new MessageResponseType();
      	message.setText(myObject.getName());
      	message.setId(String.valueOf(myObject.getId()));
         closeContext();
      }
      else{
        closeContext();
        throw new MyObjectNotFoundException(keyId);
      }
      
      return message;
    }
    @ApiOperation(value = "/delete/{keyId}", notes = "Delete", response = MessageResponseType.class)
	 @ApiResponses(value = {
  		@ApiResponse(code = 400, message = "Invalid ID supplied"),
  		@ApiResponse(code = 404, message = "Pet not found") 
	 })
    @RequestMapping(value="/delete/{keyId}",method=RequestMethod.GET)
    public MessageResponseType delete(@PathVariable String keyId)  throws MyObjectNotFoundException  {
      MyObjectService service = (MyObjectService) getContext().getBean("myObjectService");
      System.out.print("Id" +keyId);
      Boolean response = service.deleteMyObjectBySsn(keyId);
      closeContext();
      if(response == false){
      	throw new MyObjectNotFoundException(keyId);
      }
      
      return null;
    }
    
    @ExceptionHandler(MyObjectNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public @ResponseBody MyObjectException handleMyObjectNotFoundException(MyObjectNotFoundException exception){
		MyObjectException customException = new MyObjectException();
      customException.setMessage(exception.getMessage());
      return customException;
	}
}
