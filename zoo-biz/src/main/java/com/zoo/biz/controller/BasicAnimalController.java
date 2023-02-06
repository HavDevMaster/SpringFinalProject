package com.zoo.biz.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Habitats;
import com.zoo.biz.service.AnimalService;


@RestController
public class BasicAnimalController implements AnimalController {

  @Autowired
  private AnimalService animalService;
  

@Override
public List<Animals> fetchAllAnimals() {                                                    
  return animalService.fetchAllAnimals();
}

  @Override
  public Animals createAnimal(String animalName, String species, Habitats habitatId) {
    return animalService.createAnimal(animalName, species, habitatId);
  }

  
  @Override
  public Animals updateAnimal(int animalPK, String animalName, String species, Habitats habitatId,
      @Valid Animals updatedAnimal) {
    updatedAnimal.setAnimalName(animalName);
    updatedAnimal.setSpecies(species);
    updatedAnimal.setHabitatId(habitatId);
    return animalService.updateAnimal(animalPK, updatedAnimal, species, habitatId);
  }



}


