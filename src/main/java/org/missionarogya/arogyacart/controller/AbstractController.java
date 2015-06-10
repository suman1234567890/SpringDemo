package org.missionarogya.arogyacart.controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import org.missionarogya.arogyacart.configuration.Hibernate.HibernateConfiguration; 

public abstract class AbstractController {
  
  private AbstractApplicationContext context;
  
  protected AbstractApplicationContext getContext(){
    context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
    return context;
  }
  protected void closeContext(){
    context.close();
  }
}
