package org.polytech.polyfood.buisness;

import java.math.BigDecimal;

public class OrderLineItem {


    private Long menuId;
    private String name;
    private BigDecimal price;

    public OrderLineItem(Long menuId, String name, BigDecimal price) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
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
