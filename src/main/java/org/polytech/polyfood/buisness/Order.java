package org.polytech.polyfood.buisness;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "T_ORDER")
public class Order {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONSUMER_ID")
    private final Long consumerId;

    @Column(name = "RESTAURANT_ID")
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
