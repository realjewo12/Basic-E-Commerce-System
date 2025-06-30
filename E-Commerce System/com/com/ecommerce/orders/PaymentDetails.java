package com.ecommerce.orders;

public class PaymentDetails {
    private String paymentMethod;
    private String transactionID;
    private boolean isPaid;

    public PaymentDetails(String paymentMethod, String transactionID, boolean isPaid) {
        this.paymentMethod = paymentMethod;
        this.transactionID = transactionID;
        this.isPaid = isPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return paymentMethod + " (Transaction ID: " + transactionID + ")";
    }
}
