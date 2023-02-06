package com.zoo.biz.entity;

public enum Habitats {
  SAVANNAH, JUNGLE, DESERT, ARCTIC, AQUATIC;

  public String toUpperCase() {
    // TODO Auto-generated method stub
    return this.name().toUpperCase();
  }
}

