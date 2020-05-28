package org.polytech.polyfood;


import org.polytech.polyfood.buisness.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(AppConfiguration.class);


        OrderService orderService = context.getBean(OrderService.class);

        Long consumerId = 982738L;
        Long restaurantId = 62937L;
        OrderLineItem item1 = new OrderLineItem(9L, "Salade papaye thaïlandaise", BigDecimal.valueOf(8.9));
        OrderLineItem item2 = new OrderLineItem(9L, "Fruits", BigDecimal.valueOf(5.9));
        OrderLineItem item3 = new OrderLineItem(9L, "Evian", BigDecimal.valueOf(2.5));
        List<OrderLineItem> orderLineItems = Arrays.asList(item1, item2, item3);

        DeliveryInformation deliveryInformation = new DeliveryInformation("33 Rue la Fayette", "75009", "DC 6382");

        PaymentInformation paymentInformation = new PaymentInformation("826786839822809", "02/2022", "762");

        Order order = new Order(consumerId, restaurantId, orderLineItems, deliveryInformation, paymentInformation);
        orderService.createOrder(order);


        List<Order> orders = orderService.fetchConsumerOrders(consumerId);
        for (Order o : orders) {
            System.out.println(o.toString());
        }

    }
}
