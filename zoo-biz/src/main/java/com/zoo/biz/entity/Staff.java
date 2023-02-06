package com.zoo.biz.entity;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
  public int staffPK;
  private String firstName;
  private String lastName;
  private String phone;
  
  private BigDecimal payRate;

}
