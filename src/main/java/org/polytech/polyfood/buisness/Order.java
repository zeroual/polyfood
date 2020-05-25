package org.polytech.polyfood.buisness;

import java.util.List;

public class Order {
    private final Long consumerId;
    private final Long restaurantId;
    private final List<OrderLineItem> orderLineItems;
    private final DeliveryInformation deliveryInformation;
    private final PaymentInformation paymentInformation;

    public Order(Long consumerId, Long restaurantId, List<OrderLineItem> orderLineItems,
                 DeliveryInformation deliveryInformation, PaymentInformation paymentInformation) {

        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
        this.orderLineItems = orderLineItems;
        this.deliveryInformation = deliveryInformation;
        this.paymentInformation = paymentInformation;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public DeliveryInformation getDeliveryInformation() {
        return deliveryInformation;
    }

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    @Override
    public String toString() {
        return "Order{" +
                "consumerId=" + consumerId +
                ", restaurantId=" + restaurantId +
                ", orderLineItems=" + orderLineItems +
                ", deliveryInformation=" + deliveryInformation +
                ", paymentInformation=" + paymentInformation +
                '}';
    }
}
