package com.zoo.biz.dao;

import java.util.List;
import javax.validation.Valid;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Habitats;

public interface AnimalDao {
                                                           
  List<Animals> fetchAllAnimals(); 
  
  Animals createAnimal(String animalName, String species, Habitats habitatId);                    

  Animals updateAnimal(int animalPK, @Valid Animals updatedAnimal, String animalId, Habitats habitatId);                           



 
}

