package io.introdev.strategyPattern.controller;

import io.introdev.strategyPattern.model.Order;
import io.introdev.strategyPattern.model.OrderApiResponse;
import io.introdev.strategyPattern.service.OrderProcessingService;
import java.util.Map;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * This controller will get an order and dynamically decide what order processor to use
 * no if/else.
 */
@RestController
public class OrderController {


  private final Map<String, OrderProcessingService> orderProcessingServices;

  public OrderController(
      Map<String, OrderProcessingService> orderProcessingServices) {
    this.orderProcessingServices = orderProcessingServices;
  }


  @PostMapping("/order")
  public Mono<OrderApiResponse> onNewOrder(@RequestBody Order receivedOrder) {

    return this.orderProcessingServices.get(receivedOrder.getOrderType().name())
        .processOrder(receivedOrder);

  }


}
