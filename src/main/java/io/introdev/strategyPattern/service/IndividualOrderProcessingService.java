package io.introdev.strategyPattern.service;

import io.introdev.strategyPattern.model.Order;
import io.introdev.strategyPattern.model.OrderApiResponse;
import java.util.function.BiConsumer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

@Component("INDIVIDUAL")
public class IndividualOrderProcessingService implements OrderProcessingService {

  @Override
  public Mono<OrderApiResponse> processOrder(Order order){
    return Mono.just(order)
          .handle(this.handleOrder());
  }


  private BiConsumer<Order, SynchronousSink<OrderApiResponse>> handleOrder(){
    return (order, sink) -> {
      if(order.getMethodOfPayment() == null){
        sink.next(OrderApiResponse.builder().order(order).orderStatus("INVALID").status(HttpStatus.BAD_REQUEST.value()).build());
      }else{
        sink.next(OrderApiResponse.builder().order(order).orderStatus("PROCESSED").status(HttpStatus.ACCEPTED.value()).build());
      }
    };
  }
}
