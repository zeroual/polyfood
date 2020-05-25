package org.polytech.polyfood.buisness;

public class DeliveryInformation {
    private final String address;
    private final String zipCode;
    private final String details;

    public DeliveryInformation(String address, String zipCode, String details) {

        this.address = address;
        this.zipCode = zipCode;
        this.details = details;
    }
}
