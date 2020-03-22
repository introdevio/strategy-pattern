package io.introdev.strategyPattern.model;


import lombok.Builder;
import lombok.Data;

/**
 * This class represents a corporation. This object will be added to all "PROCESSED" orders
 */
@Data
@Builder
public class Corporation {


  private String companyName;
  private String corpCode;
  

}
