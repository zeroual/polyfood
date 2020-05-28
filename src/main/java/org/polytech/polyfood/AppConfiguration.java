package org.polytech.polyfood;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.polytech.polyfood.buisness.Order;
import org.polytech.polyfood.buisness.OrderLineItem;
import org.polytech.polyfood.buisness.OrderService;
import org.polytech.polyfood.persistence.JpaOrderRepository;
import org.polytech.polyfood.persistence.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class AppConfiguration {

    @Bean
    OrderService orderService() {
        return new OrderService(orderRepository());
    }

    @Bean
    OrderRepository orderRepository() {
        Session session = buildSessionFactory().openSession();
        return new JpaOrderRepository(session);
    }


    @Bean
    public SessionFactory buildSessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
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
