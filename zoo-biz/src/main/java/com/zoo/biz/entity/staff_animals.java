package com.zoo.biz.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class staff_animals {
  private int staffPK;
  private int animalPK;
  private String animalName;
 
  
}

