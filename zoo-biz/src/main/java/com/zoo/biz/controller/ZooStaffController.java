package com.zoo.biz.controller;


import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.zoo.biz.entity.Staff;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/Staff")
@OpenAPIDefinition(info = @Info(title = "staff"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface ZooStaffController {

//need one of these for the different functions 
  //i.e. Deleting, Creating, etc.
  // @formatter:off
  @Operation(
      summary = "Returns a staff member",
      description = "Returns a staff given a first and last name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "An Staff is returned",
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Staff.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Staffs were found with the input criteria",  
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.",  
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "firstName", 
              allowEmptyValue = false, 
              required = false, 
              description = "The first name (i.e., 'Haven')"),
          @Parameter(name = "lastName", 
          allowEmptyValue = false, 
          required = false, 
          description = "The last name (i.e., 'Summerfield')")
      }
  )
  //this is for gets not deletes, postmapping, deletemapping etc for the methods 
  @GetMapping("/staffs")
  @ResponseStatus(code = HttpStatus.OK)
  List<Staff> fetchStaffs(
      @RequestParam(required = false)
      String firstName,
      @RequestParam(required = false)
      String lastName);   
  //@formatter:on


// /all 
// @formatter:off
@Operation(
    summary = "Returns all Staffs",
    description = "Returns a List of Staffs",
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "A List of all Staffs is returned",
            content = @Content(
                mediaType = "application/json", 
                schema = @Schema(implementation = Staff.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No Staffs were found with the input criteria",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.",  
            content = @Content(mediaType = "application/json"))
    }
)
//this is for gets not deletes, postmapping, deletemapping etc for the methods 
      @GetMapping("/allStaffs")
      @ResponseStatus(code = HttpStatus.OK)
      List<Staff> fetchAllStaffs();  
 //@formatter:on
 

//POST
//Create Method CreateStaffs
//createStaff
// @formatter:off
@Operation(
    summary = "Creates a new staff",
    description = "Returns a new staff given a first and last name",
    responses = {
        @ApiResponse(
            responseCode = "201", 
            description = "A new Staff has been created",
            content = @Content(
                mediaType = "application/json", 
                schema = @Schema(implementation = Staff.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No Staffs component was not found with the input criteria",  
            content = @Content(mediaType = "application/json")),//maybe reword
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.",  
            content = @Content(mediaType = "application/json"))
    },
    parameters = {
        @Parameter(name = "firstName", 
            allowEmptyValue = false, 
            required = false, 
            description = "The first name (i.e., 'haven')"),
        @Parameter(name = "lastName", 
        allowEmptyValue = false, 
        required = false, 
        description = "The last name (i.e., 'summerfield')"),
         @Parameter(name = "phone", 
          allowEmptyValue = false, 
          required = false, 
          description = "phone (i.e., '555-555-5558')"),
        @Parameter(name = "payRate", 
        allowEmptyValue = false, 
        required = false, 
        description = "payRate (i.e., '40')")
    }
    
)
//this is for gets not deletes, postmapping, deletemapping etc for the methods 
      @PostMapping
      @ResponseStatus(code = HttpStatus.CREATED)
      Staff createStaff(String firstName, String lastName, String phone, BigDecimal payRate);
//@formatter:on



//Deletes Staff 
//deleteStaff
// @formatter:off
@Operation(
    summary = "Deletes an Staff",
    description = "Deletes an Staff given an id",
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Staff was deleted",
            content = @Content(
                mediaType = "application/json", 
                schema = @Schema(implementation = Staff.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No Staffs were found with the input criteria",  
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.",  
            content = @Content(mediaType = "application/json"))
    },
    parameters = {
        @Parameter(name = "staffPK", 
            allowEmptyValue = false, 
            required = false, 
            description = "staffPK (i.e., 3)"),
    }
)
//this is for gets not deletes, postmapping, deletemapping etc for the methods 
    @DeleteMapping("/staffPK")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteStaff( 
       int staffPK);
      

// @formatter:on





//@formatter:off
@Operation(
  summary = "Returns an updated Staff",
  description = "Returns a Staff to update given an id",
  responses = {
      @ApiResponse(
          responseCode = "200",
          description = "An updated Staff is returned",
          content = @Content(
              mediaType = "application/json", 
              schema = @Schema(implementation = Staff.class))),
      @ApiResponse(
          responseCode = "400", 
          description = "The request parameters are invalid",  
          content = @Content(mediaType = "application/json")),
      @ApiResponse(
          responseCode = "404", 
          description = "No Staffs were found with the input criteria",  
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
              description = "The staffs PK within our database"),
              @Parameter(name = "firstName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The firstName within our database"),
              @Parameter(name = "lastName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The staffs last name within our database"),
              @Parameter(name = "phone", 
              allowEmptyValue = false, 
              required = true, 
              description = "The staffs phone number within our database"),
}
  
)
//this is for gets not deletes, postmapping, deletemapping etc for the methods 

@PutMapping
@ResponseStatus(code = HttpStatus.OK) //this may need to be tweaked a tad 
Staff updateStaff(
  int staffPK,
  String firstName,
  String lastName,
  String phone,
  @Valid @RequestBody Staff updatedStaff);
   //formatter: off




}

  
  

