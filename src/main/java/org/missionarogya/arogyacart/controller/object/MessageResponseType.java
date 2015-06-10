package org.missionarogya.arogyacart.controller.object;

public class MessageResponseType {
  	 
    private String text;
    private String id;
 	 public void setId(String id) {
        this.id = id;
    }
 
    public String getId() {
        return id;
    }
    public void setText(String text) {
        this.text = text;
    }
 
    public String getText() {
        return text;
    }
}
