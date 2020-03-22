package io.introdev.strategyPattern.service;

import io.introdev.strategyPattern.model.Order;
import io.introdev.strategyPattern.model.OrderApiResponse;
import reactor.core.publisher.Mono;

public interface OrderProcessingService {

  Mono<OrderApiResponse> processOrder(Order order);

}
