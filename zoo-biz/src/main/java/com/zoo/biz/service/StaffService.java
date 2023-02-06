package com.zoo.biz.service;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import com.zoo.biz.entity.Staff;
public interface StaffService {
  
    List<Staff> fetchStaffs(String firstName, String lastName);

    List<Staff> fetchAllStaffs();

    void deleteStaff(int deleteId);

    

    Staff updateStaff(int staffPK, @Valid Staff updatedStaff, String firstName, String lastName,
        String phone);


    Staff createStaff(String firstName, String lastName, String phone, BigDecimal payRate);

}
