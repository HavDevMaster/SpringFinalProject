package com.zoo.biz.service;

import java.util.List;

import com.zoo.biz.entity.staff_animals;

public interface StaffAnimalService {
  
  public int assignAnimalToStaff(String staffName, int staffPK, int animalPK, String animalName);
  
  

  List<staff_animals> getAnimalsByStaffId(int staffPK);
}
