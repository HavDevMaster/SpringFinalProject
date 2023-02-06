package com.zoo.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.zoo.biz.entity.staff_animals;


@Configuration
public class DefaultStaffAnimalDao implements StaffAnimalDao {
 
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
   

  
  @Override
  public int assignAnimalToStaff(String firstName, int staffPK, int animalPK, String animalName) {
      String sql = "INSERT INTO Staff_Animals (staffPK, animalPK) VALUES (:staffPK, :animalPK)";

      Map<String, Object> params = new HashMap<>();
      params.put("staffPK", staffPK);
      params.put("animalPK", animalPK);

      int result = jdbcTemplate.update(sql, params);
      System.out.println("Assigned animal with name '" + animalName + "' and PK " + animalPK + " to staff member '" + firstName + "' with PK " + staffPK);

      return result;
  }


  
    

  @Override
  public List<staff_animals> getAnimalsForStaff(int staffPK) {
    String sql = "SELECT Staff_Animals.animalPK, Staff_Animals.staffPK, Animals.animalName " +
        "FROM Staff_Animals " +
        "INNER JOIN Staff ON Staff.staffPK = Staff_Animals.staffPK " +
        "INNER JOIN Animals ON Staff_Animals.animalPK = Animals.animalPK " +
        "WHERE Staff_Animals.staffPK = :staffPK";

Map<String, Object> params = new HashMap<>();
params.put("staffPK", staffPK);

List<staff_animals> animals = jdbcTemplate.query(sql, params, new RowMapper<staff_animals>() {
    @Override
    public staff_animals mapRow(ResultSet rs, int rowNum) throws SQLException {
        return staff_animals.builder()
            .staffPK(rs.getInt("staffPK"))
            .animalPK(rs.getInt("animalPK"))
            .animalName(rs.getString("animalName"))
            .build();
    }
});


      System.out.println("Animals for staff member with PK " + staffPK + ": " + animals);

      return animals;
  }

}
