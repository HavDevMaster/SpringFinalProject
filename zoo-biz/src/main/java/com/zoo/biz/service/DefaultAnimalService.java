package com.zoo.biz.service;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zoo.biz.dao.AnimalDao;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Habitats;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
class DefaultAnimalService implements AnimalService {

  @Autowired
  private AnimalDao animalDao;

  @Override
  public Animals createAnimal(String animalName, String species, Habitats habitatId) {           
    log.info("create Animals in service layer");
    return animalDao.createAnimal(animalName, species, habitatId);
  }

  @Override
  public Animals updateAnimal(int animalPK, @Valid Animals updatedAnimal, String species,
      Habitats habitatId) {
    log.info("updates Animal in service layer");
    return animalDao.updateAnimal(animalPK, updatedAnimal, species, habitatId);
  }

  @Override
  public List<Animals> fetchAllAnimals() {                                                  
    List<Animals> animals = animalDao.fetchAllAnimals();
    if(animals.isEmpty()) {
      String msg = String.format("We have no customers :(");
          throw new NoSuchElementException(msg);
    }
   // Collections.sort((List<Employee>) employees);
    return animals;
  }
  

}