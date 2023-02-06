package com.zoo.biz.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animals {

    private int animalPK;
    private String animalName;
    private String species;
    private Habitats habitatId;
  }

