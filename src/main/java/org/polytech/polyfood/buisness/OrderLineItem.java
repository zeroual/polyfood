package org.polytech.polyfood.buisness;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "T_ORDER_LINE_ITEM")
public class OrderLineItem {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MENU_ID")
    private Long menuId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    public OrderLineItem(Long menuId, String name, BigDecimal price) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
    }

    public OrderLineItem() {
    }

    public Long getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
