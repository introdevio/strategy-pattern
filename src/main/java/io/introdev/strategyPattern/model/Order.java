package io.introdev.strategyPattern.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Data;


/**
 * This class simply represents an order which can be from an individual or a corporate customer
 * this class will be used to execute a particular processing depending on the OrderType
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Order {

  public enum MethodOfPayment {

    CREDIT_CARD,
    DEBIT_CARD,
    CORPORATE_ACCOUNT

  }

  public enum OrderType{
    CORPORATE,
    INDIVIDUAL
  }

  private Customer customer;
  private OrderType orderType;
  private String corpCode;
  private MethodOfPayment methodOfPayment;
  private Corporation corporation;
  private List<String> articles;



}
