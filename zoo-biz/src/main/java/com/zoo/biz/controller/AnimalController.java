package com.zoo.biz.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Habitats;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/Animals")
@OpenAPIDefinition(info = @Info(title = "Animals"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface AnimalController {

  //Animals Controller interface then talks to the Default Animals Controller class.

  
  // @formatter:off
  @Operation(
      summary = "Creates a new Animal",
      description = "Returns the created Animals",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A new Animals has been added",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Animals were found",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json")),
      },
      parameters = {
          @Parameter(name = "animalName", 
              allowEmptyValue = false, 
              required = false, 
              description = "The animals name"),
          @Parameter(name = "species", 
          allowEmptyValue = false, 
          required = false, 
          description = "The animals species"),
          @Parameter(name = "habitatId", 
          allowEmptyValue = false, 
          required = false, 
          description = "The animals habitat."),
         
          }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Animals createAnimal(String animalName, String species, Habitats habitatId);                    
  
  
  
  
  
  // @formatter:off
  @Operation(
      summary = "updates a Animal",
      description = "Returns the updated Animals",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Returns updated Animals",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Animals were found",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json")),
      }, 
          parameters = {
              @Parameter(name = "animalPK", 
                  allowEmptyValue = false, 
                  required = true, 
                  description = "The Animals's PK within our database"),
                  @Parameter(name = "animalName", 
                  allowEmptyValue = false, 
                  required = true, 
                  description = "The animalName within our database"),
                  @Parameter(name = "species", 
                  allowEmptyValue = false, 
                  required = true, 
                  description = "The animal's species within our database"),
                  @Parameter(name = "habitatId", 
                  allowEmptyValue = false, 
                  required = true, 
                  description = "The animal's habitat within our database"),
      }
  )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Animals updateAnimal( 
       int animalPK,
       String animalName,
       String species,
      Habitats habitatId,
      @Valid @RequestBody Animals updatedAnimal);
 
  // @formatter:off
  @Operation(
      summary = "Returns a list of Animals",
      description = "Returns a list of Animals all first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of Animals is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Animals were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      }

  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Animals> fetchAllAnimals(                                                            
    );
  }
      
     
  




