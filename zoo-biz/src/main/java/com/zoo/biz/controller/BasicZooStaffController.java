package com.zoo.biz.controller;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.zoo.biz.entity.Animals;
import com.zoo.biz.entity.Staff;
import com.zoo.biz.service.StaffService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicZooStaffController implements ZooStaffController {
  
  @Autowired
  private StaffService staffService;
  
  
  @Override
  public List<Staff> fetchStaffs(String firstName, String lastName) {
    log.debug("firstName={}, lastName={}", firstName, lastName);
      return staffService.fetchStaffs(firstName, lastName);

}

  @Override
  public Staff createStaff(String firstName, String lastName, String phone, BigDecimal payRate) {
    return staffService.createStaff(firstName, lastName, phone, payRate);
  }


  @Override
  public List<Staff> fetchAllStaffs() {
    return staffService.fetchAllStaffs();
  }

  @Override
  public Staff updateStaff(int staffPK, String firstName, String lastName, String phone,
      @Valid Staff updatedStaff) {
      updatedStaff.setFirstName(firstName);
      updatedStaff.setLastName(lastName);
      updatedStaff.setPhone(phone);
      return staffService.updateStaff(staffPK, updatedStaff, firstName, lastName, phone);
  }

  @Override
  public void deleteStaff(int staffPK) {
    log.debug("staffPK={}", staffPK);
    staffService.deleteStaff(staffPK);
  }

  
}