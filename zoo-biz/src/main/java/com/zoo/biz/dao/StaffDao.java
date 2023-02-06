package com.zoo.biz.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import com.zoo.biz.entity.Staff;

public interface StaffDao {
  
    List<Staff> fetchStaffs(String firstName, String lastName);

    List<Staff> fetchAllStaffs();

    void deleteStaff(int staffPK);


    Staff updateStaff(int staffPK, @Valid Staff updatedStaff, String firstName, String lastName, String phone);

    Staff createStaff(String firstName, String lastName, String phone, BigDecimal payRate); 

   
  }

   
  

