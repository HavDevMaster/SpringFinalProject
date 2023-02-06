package com.zoo.biz.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zoo.biz.entity.staff_animals;
import com.zoo.biz.service.StaffAnimalService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/staff_animals")
public class BasicStaffAnimalController implements StaffAnimalController {

    @Autowired
    private StaffAnimalService staffAnimalService;

    @Override
    public int assignAnimalToStaff(String firstName, int staffPK, int animalPK, String animalName) {
       return staffAnimalService.assignAnimalToStaff(firstName, staffPK, animalPK, animalName);
        
    }

    @Override
    public List<staff_animals> getAnimalsByStaffId(int staffPK) {
        List<staff_animals> animals = staffAnimalService.getAnimalsByStaffId(staffPK);
        return animals;
    }
}
    
   

