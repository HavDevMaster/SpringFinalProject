package com.zoo.biz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoo.biz.dao.StaffAnimalDao;
import com.zoo.biz.entity.staff_animals;

@Service
public class DefaultStaffAnimalService implements StaffAnimalService{

  @Autowired
  private StaffAnimalDao staffAnimalDao;

  public int assignAnimalToStaff(String staffName, int staffPK, int animalPK, String animalName) {
      return staffAnimalDao.assignAnimalToStaff(staffName, staffPK, animalPK, animalName);
  }

  @Override
  public List<staff_animals> getAnimalsByStaffId(int staffPK) {
    return staffAnimalDao.getAnimalsForStaff(staffPK);
  }

}


 