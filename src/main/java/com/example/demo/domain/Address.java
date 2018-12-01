package com.example.demo.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String country;
    private String postalCode;
    private String city;
    private String street;
    private String apartament;

    public Address() {
    }

    ;

    public Address(String country, String postalCode, String city, String street, String apartament) {
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.apartament = apartament;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartament() {
        return apartament;
    }

    public void setApartament(String apartament) {
        this.apartament = apartament;
    }

    @Override
    public String toString() {
        return "Address{" + "country='" + country + '\'' + ", postalCode='" + postalCode + '\'' + ", city='" + city + '\'' + ", street='" + street + '\'' + ", apartament='" + apartament + '\'' + '}';
    }
}
