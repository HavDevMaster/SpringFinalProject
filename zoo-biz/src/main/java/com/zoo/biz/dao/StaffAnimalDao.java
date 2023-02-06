package com.zoo.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.zoo.biz.entity.staff_animals;

public interface StaffAnimalDao {




   int assignAnimalToStaff(String staffName, int staffPK, int animalPK, String animalName);

  List<staff_animals> getAnimalsForStaff(int staffPK);


}
   

//one to many animal has multiple staff


