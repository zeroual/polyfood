package org.polytech.polyfood.buisness;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_ORDER")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONSUMER_ID")
    private  Long consumerId;

    @Column(name = "RESTAURANT_ID")
    private  Long restaurantId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private  List<OrderLineItem> orderLineItems;

    @Embedded
    private  DeliveryInformation deliveryInformation;

    @Embedded
    private  PaymentInformation paymentInformation;

    public Order(Long consumerId, Long restaurantId, List<OrderLineItem> orderLineItems,
                 DeliveryInformation deliveryInformation, PaymentInformation paymentInformation) {

        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
        this.orderLineItems = orderLineItems;
        this.deliveryInformation = deliveryInformation;
        this.paymentInformation = paymentInformation;
    }

    public Order() {
    }

    public Long getId() {
        return id;
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

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public void setDeliveryInformation(DeliveryInformation deliveryInformation) {
        this.deliveryInformation = deliveryInformation;
    }

    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}
