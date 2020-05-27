package org.polytech.polyfood;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.polytech.polyfood.buisness.*;
import org.polytech.polyfood.persistence.JpaOrderRepository;
import org.polytech.polyfood.persistence.OrderRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {


    public static void main(String[] args) {

        SessionFactory sessionFactory = buildSessionFactory();


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        OrderRepository orderRepository = new JpaOrderRepository(session);

        OrderService orderService = new OrderService(orderRepository);

        Long consumerId = 982738L;
        Long restaurantId = 62937L;
        OrderLineItem item1 = new OrderLineItem(9L, "Salade papaye thaïlandaise", BigDecimal.valueOf(8.9));
        OrderLineItem item2 = new OrderLineItem(9L, "Fruits", BigDecimal.valueOf(5.9));
        OrderLineItem item3 = new OrderLineItem(9L, "Evian", BigDecimal.valueOf(2.5));
        List<OrderLineItem> orderLineItems = Arrays.asList(item1, item2, item3);

        DeliveryInformation deliveryInformation = new DeliveryInformation("33 Rue la Fayette","75009","DC 6382");

        PaymentInformation paymentInformation = new PaymentInformation("826786839822809","02/2022","762");

        Order order = new Order(consumerId, restaurantId, orderLineItems, deliveryInformation, paymentInformation);
        orderService.createOrder(order);

        transaction.commit();


        List<Order> orders = orderService.fetchConsumerOrders(consumerId);
        for (Order o : orders) {
            System.out.println(o.toString());
        }

    }

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/polyfood");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "rootpw");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        //settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(OrderLineItem.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
       return configuration.buildSessionFactory(serviceRegistry);
    }

}
