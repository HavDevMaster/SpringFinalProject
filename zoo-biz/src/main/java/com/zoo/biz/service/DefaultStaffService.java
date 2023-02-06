package com.zoo.biz.service;

  import java.math.BigDecimal;
  import java.util.List;
  import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  import org.springframework.transaction.annotation.Transactional;
import com.zoo.biz.dao.StaffDao;
import com.zoo.biz.entity.Staff;
import lombok.extern.slf4j.Slf4j;

  @Service
  @Slf4j
  public class DefaultStaffService implements StaffService {
      
      @Autowired
      private StaffDao staffDao;

      @Transactional(readOnly = true)
      @Override
      public List<Staff> fetchStaffs(String firstName, String lastName) {
        log.info("The fetchStaffs method was called with firstName={} lastName={}",
            firstName, lastName);
        
        List<Staff> staffs = staffDao.fetchStaffs(firstName, lastName);
        
        
        
       // Collections.sort((List<Staff>) staffs);
        return staffs;
      }

      @Transactional(readOnly = true)
      @Override
      public List<Staff> fetchAllStaffs() {
          
          
          List<Staff> staffs = staffDao.fetchAllStaffs();
          
          
          if(staffs.isEmpty()) {
            String msg = String.format("We have no staffs");
                throw new NoSuchElementException(msg);
          }
          
         // Collections.sort((List<Staff>) staffs);
          return staffs;
        }

      //@Transactional(readOnly = false)
      @Override
      public Staff createStaff(String firstName, String lastName, String phone, BigDecimal payRate) {
  log.info("create Staffs in service layer");
  return staffDao.createStaff(firstName, lastName, phone, payRate);
  }



      //@Transactional(readOnly = false)
      @Override
      public void deleteStaff(int staffPK) {
          log.info("The deleteStaff method was called with staffPK={}",
              staffPK);
          
         staffDao.deleteStaff(staffPK);
         //In future business logic is done within the service layer and could be checked here 
         //change method to be public int deleteStaff and check like above(like in the dao)S
          
        }

      //This could mimic the create method 
     // @Transactional(readOnly = false)
    

      @Override
      public Staff updateStaff(int staffPK, @Valid Staff updatedStaff, String firstName,
          String lastName, String phone) {
        log.info("updates Staff in service layer");
        return staffDao.updateStaff(staffPK, updatedStaff, firstName, lastName, phone);
      }

    
      }

    




