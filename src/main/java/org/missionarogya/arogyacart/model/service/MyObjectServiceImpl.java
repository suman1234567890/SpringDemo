package org.missionarogya.arogyacart.model.service;
import org.missionarogya.arogyacart.model.dao.MyObjectDao;
import org.missionarogya.arogyacart.model.dao.object.MyObject;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
@Service("myObjectService")
@Transactional
public class MyObjectServiceImpl implements MyObjectService{
   @Autowired
    private MyObjectDao dao;
     
    public void saveObject(MyObject myObject) {
        dao.saveObject(myObject);
    }
 
    public List<MyObject> findAllObjects()  {
        return dao.findAllObjects();
    }
 
    public Boolean deleteMyObjectBySsn(String ssn)  {
        MyObject myObject = findBySsn(ssn);
        if(myObject != null){
          dao.deleteMyObjectBySsn(ssn);
          return true;
        }
        else{
          return false;
        }
    }
 
    public MyObject findBySsn(String ssn) {
        return dao.findBySsn(ssn);
    }
 
    public void updateMyObject(MyObject myObject){
        dao.updateMyObject(myObject);
    }
}
