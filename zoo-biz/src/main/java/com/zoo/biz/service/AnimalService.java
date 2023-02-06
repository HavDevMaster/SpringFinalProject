package com.zoo.biz.service;

import java.util.List;
import javax.validation.Valid;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Habitats;

public interface AnimalService {

                                                         
                                                                

  Animals createAnimal(String animalName, String species, Habitats habitatId);                    
  

  Animals updateAnimal(int animalPK, @Valid Animals updatedAnimal, String species,
      Habitats habitatId);


 


  List<Animals> fetchAllAnimals();




  
 
                            

}
