package io.github.uazw.domain;

public class Address {

    private long addressId;
    private String streetName;


    public Address(Integer addressId, String streetName) {
        this.addressId = addressId;
        this.streetName = streetName;
    }

    public long getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }
}
