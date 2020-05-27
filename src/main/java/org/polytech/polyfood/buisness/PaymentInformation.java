package org.polytech.polyfood.buisness;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentInformation {

    @Column(name = "CREDIT_CARD")
    private  String creditCard;

    @Column(name = "END_DATE")
    private  String endDate;

    @Column(name = "SECURITY_CODE")
    private  String securityCode;

    public PaymentInformation() {
    }

    public PaymentInformation(String creditCard, String endDate, String securityCode) {

        this.creditCard = creditCard;
        this.endDate = endDate;
        this.securityCode = securityCode;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }
}
