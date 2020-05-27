package org.polytech.polyfood.buisness;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DeliveryInformation {
    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DETAILS")
    private String details;

    public DeliveryInformation() {
    }

    public DeliveryInformation(String address, String zipCode, String details) {

        this.address = address;
        this.zipCode = zipCode;
        this.details = details;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getDetails() {
        return details;
    }
}
