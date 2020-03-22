package io.introdev.strategyPattern.model;

import lombok.Builder;
import lombok.Data;

/**
 * This class simply represents a response status
 * we use this in this project because i was lazy to create exception handlers :)
 */
@Data
@Builder
public class OrderApiResponse {

  private int status;
  private String orderStatus;
  private Order order;

}
