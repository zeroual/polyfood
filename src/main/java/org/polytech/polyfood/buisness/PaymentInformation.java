package org.polytech.polyfood.buisness;

public class PaymentInformation {
    private final String creditCard;
    private final String endDate;
    private final String securityCode;

    public PaymentInformation(String creditCard, String endDate, String securityCode) {

        this.creditCard = creditCard;
        this.endDate = endDate;
        this.securityCode = securityCode;
    }
}
