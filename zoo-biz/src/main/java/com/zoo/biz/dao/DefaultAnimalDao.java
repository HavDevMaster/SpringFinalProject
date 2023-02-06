package com.zoo.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Habitats;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultAnimalDao implements AnimalDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
   

  public Animals createAnimal(String animalName, String species, Habitats habitatId) {            
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into animals "
        + "(animalName, species, habitatId)" 
        + "VALUES (:animalName, :species, :habitatId)" ;
    sqlparams.source.addValue("animalName", animalName);
    sqlparams.source.addValue("species", species);
    sqlparams.source.addValue("habitatId", habitatId.name());
    

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Animals.builder()
        .animalPK((int) keyHolder.getKey().intValue())
        .animalName(animalName)
        .species(species)
        .habitatId(habitatId)
        .build();
  }


  //This is needed in order to fully implement the create function. 
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  

public Animals updateAnimal(int animalPK, Animals updatedAnimal, String animalName, Habitats habitatId) {    
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    // @formatter:off

    sqlparams.sql = ""
        + "UPDATE animals "
        + "SET "
        + "animalName = :animalName, "
        + "species = :species, "
        + "habitatId = :habitatId "
        + "WHERE animalPK = :animalPK;";
    // @formatter:on

    sqlparams.source.addValue("animalName", updatedAnimal.getAnimalName());
    sqlparams.source.addValue("species", updatedAnimal.getSpecies());
    sqlparams.source.addValue("animalPK", animalPK);
    
    Habitats habitat = Habitats.valueOf(updatedAnimal.getHabitatId().toUpperCase());
    sqlparams.source.addValue("habitatId", habitat.name());
   
    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Animals.builder()
        .animalPK(animalPK)
        .animalName(updatedAnimal.getAnimalName())
        .species(updatedAnimal.getSpecies())
        .habitatId(updatedAnimal.getHabitatId())
        .build();
}
public List<Animals> fetchAllAnimals() {                                                  
  log.info("In animal.dao.fetchAllAnimals");
  
  //sql code for the command
    // @formatter:off
    String sql = ""
        +"SELECT * "
        + "FROM animals;";
    // @formatter:on  
  
  //creates a map of objects and then returns with a builder throwing together all of 
  //the information you want to output from the sql database.
    Map<String, Object> params = new HashMap<>();
    List<Animals> animals = jdbcTemplate.query(sql,
        new RowMapper<Animals>() {
          @Override
          public Animals mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return Animals.builder()
                .animalPK(rs.getInt("animalPK"))
                .animalName(rs.getString("animalName"))
                .build();
            // @formatter:on
          }});
    for (Animals animal : animals) {
      System.out.println("Name: " + animal.getAnimalName() + " PK: " + animal.getAnimalPK());
    }

    return animals;
  }


 }


