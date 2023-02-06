package com.zoo.biz.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.zoo.biz.dao.DefaultAnimalDao.SqlParams;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Staff;
import lombok.extern.slf4j.Slf4j;
//@Service
@Component
@Slf4j
public class DefaultStaffDao implements StaffDao{
  @Autowired 
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Staff> fetchStaffs(String firstName, String lastName) {
      log.debug("DAO: first name={}, last name={}", firstName, lastName);
      // @formatter:off

      String sql = ""
          + "SELECT * "
          + "FROM staff "
          + "WHERE firstName = :firstName AND lastName = :lastName";
      // @formatter:on

      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue("firstName", firstName);
      paramSource.addValue("lastName", lastName);

      List<Staff> staffs = jdbcTemplate.query(sql, paramSource,
          new RowMapper<>() {
            @Override
            public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
              // @formatter:off

              return Staff.builder()
                  .staffPK(rs.getInt("staffPK"))
                  .firstName(rs.getString("firstName"))
                  .lastName(rs.getString("lastName"))
                  .payRate(rs.getBigDecimal("payRate"))
                  .build();
              // @formatter:on
          }});
      for (Staff staff : staffs) {
        System.out.println(" PK: " + staff.getStaffPK());
        System.out.println(" firstName: " + staff.getFirstName());
        System.out.println(" lastName: " + staff.getLastName());
        System.out.println( " payRate: " + staff.getPayRate());
      }
      return staffs;
    }



//new functions implemented in here 
  //May not always need a rowmapper i.e. in delete 
  
  @Override
  public List<Staff> fetchAllStaffs() {

    log.info("In staff.dao.fetchAllStaffs");

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM staff; ";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    List<Staff> staffList = jdbcTemplate.query(sql,
        new RowMapper<Staff>() {
          @Override
          public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return Staff.builder()
                .staffPK( rs.getInt("staffPK"))               
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .phone(rs.getString("phone"))
                .payRate(rs.getBigDecimal("payRate"))
                .build();
         // @formatter:on
          }});

    for (Staff staff : staffList) {
      System.out.println(
        " PK: " 
      + staff.getStaffPK()
      + " firstName: " 
      + staff.getFirstName() 
      + " LastName: "
      + staff.getLastName()
      + " phone: " 
      +  staff.getPhone()
      + " payRate: "
      + staff.getPayRate());
    }

    return staffList;
  }

  
  public Staff createStaff(String firstName, String lastName, String phone, BigDecimal payRate) {            //!!!
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into staff "
        + "(firstName, lastName, phone, payRate)" 
        + "VALUES (:firstName, :lastName, :phone, :payRate)" ;
    sqlparams.source.addValue("firstName", firstName);
    sqlparams.source.addValue("lastName", lastName);
    sqlparams.source.addValue("phone", phone);
    sqlparams.source.addValue("payRate", payRate);
    

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Staff.builder()
        .staffPK(keyHolder.getKey().intValue())
        .firstName(firstName)
        .lastName(lastName)
        .phone(phone)
        .payRate(payRate)
        .build();
  }

  
  @Override
  public void deleteStaff(int staffPK) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM staff "
        + "WHERE staffPK = :staffPK;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("staffPK", staffPK);    
    if (jdbcTemplate.update(sql,  params) == 0) throw new NoSuchElementException();
  }
  

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  @Override
  public Staff updateStaff(int staffPK, Staff updatedStaff, String firstName,
      String lastName, String phone) {
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    // @formatter:off
    sqlparams.sql = ""
        + "UPDATE staff "
        + "SET "
        + "firstName = :firstName, "
        + "lastName = :lastName, "
        + "phone = :phone "
        + "WHERE staffPK = :staffPK;";
    // @formatter:on
    
    
    sqlparams.source.addValue("firstName", updatedStaff.getFirstName());
    sqlparams.source.addValue("lastName", updatedStaff.getLastName());
    sqlparams.source.addValue("phone", updatedStaff.getPhone());
    sqlparams.source.addValue("staffPK", staffPK);
    
    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
   return Staff.builder()
       .staffPK(staffPK)
       .firstName(updatedStaff.getFirstName())
       .lastName(updatedStaff.getLastName())
       .phone(updatedStaff.getPhone())
       .build();
   
 }




}

