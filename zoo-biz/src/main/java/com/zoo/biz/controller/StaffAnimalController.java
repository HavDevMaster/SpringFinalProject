package com.zoo.biz.controller;

  import java.util.List;
  import org.springframework.http.HttpStatus;
  import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.bind.annotation.ResponseStatus;
  import com.zoo.biz.entity.staff_animals;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
  import io.swagger.v3.oas.annotations.Operation;
  import io.swagger.v3.oas.annotations.Parameter;
  import io.swagger.v3.oas.annotations.info.Info;
  import io.swagger.v3.oas.annotations.media.Content;
  import io.swagger.v3.oas.annotations.media.Schema;
  import io.swagger.v3.oas.annotations.responses.ApiResponse;
  import io.swagger.v3.oas.annotations.servers.Server;


  @Validated
  @RequestMapping("/staff_animals")
  @OpenAPIDefinition(info = @Info(title = "staff"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})
  public interface StaffAnimalController {
  
  //need one of these for the different functions 
    //i.e. Deleting, Creating, etc.
    // @formatter:off
    @Operation(
        summary = "Assign an animal to a staff member",
        description = "Assigns an animal to a staff member based on the staff's first name, staff ID, animal ID, and animal name",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "The assignment was successful"),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid"),
            @ApiResponse(
                responseCode = "404", 
                description = "No staff or animal was found with the input criteria"),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred.")
        },
        parameters = {
            @Parameter(name = "firstName", 
                required = true, 
                description = "The first name of the staff member"),
            @Parameter(name = "staffPK", 
                required = true, 
                description = "The PK of the staff member"),
            @Parameter(name = "animalPK", 
                required = true, 
                description = "The PK of the animal"),
            @Parameter(name = "animalName", 
                required = true, 
                description = "The name of the animal")
        }
    )
    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    int assignAnimalToStaff(
         String firstName, 
         int staffPK, 
         int animalPK, 
         String animalName);
    
    @Operation(
        summary = "Returns a list of animals assigned to a staff member",
        description = "Returns a list of animals assigned to a staff given the staff's id",
        responses = {
        @ApiResponse(
        responseCode = "200",
        description = "A list of animals assigned to a staff member is returned",
        content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = staff_animals.class))),
        @ApiResponse(
        responseCode = "400",
        description = "The request parameters are invalid",
        content = @Content(mediaType = "application/json")),
        @ApiResponse(
        responseCode = "404",
        description = "No animals were found assigned to the input staff member",
        content = @Content(mediaType = "application/json")),
        @ApiResponse(
        responseCode = "500",
        description = "An unplanned error occurred.",
        content = @Content(mediaType = "application/json"))
        },
        parameters = {
        @Parameter(name = "staffPK",
        allowEmptyValue = false,
        required = true,
        example = "1",
        description = "The PK of the staff member",
        schema = @Schema(type = "integer", format = "int64")),
        })
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
        List<staff_animals> getAnimalsByStaffId(@Parameter(description = "The id of the staff member") int staffPK);

  

  }    
  