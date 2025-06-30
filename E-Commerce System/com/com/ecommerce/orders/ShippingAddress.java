package com.ecommerce.orders;

public class ShippingAddress {
    private String street;
    private String city;
    private String country;
    private String postalCode;

    public ShippingAddress(String street, String city, String country, String postalCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + country + " - " + postalCode;
    }
}
