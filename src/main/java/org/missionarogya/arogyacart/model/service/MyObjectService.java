package org.missionarogya.arogyacart.model.service;
import java.util.List;
import org.missionarogya.arogyacart.model.dao.object.MyObject;
public interface MyObjectService {
  void saveObject(MyObject myObject);
     
    List<MyObject> findAllObjects();
     
    Boolean deleteMyObjectBySsn(String ssn);
     
    MyObject findBySsn(String ssn);
     
    void updateMyObject(MyObject myObject);
}
