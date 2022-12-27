package model;

import lombok.Data;

@Data
public class Address {

    public static final String ADDRESS_PAGE_URL = "http://prestashop.qatestlab.com.ua/ru/address";
    public static final String ADDRESSES_PAGE_URL = "http://prestashop.qatestlab.com.ua/ru/addresses";

    private String firstName = "Imia";
    private String lastName = "Familia";
    private String address = "Kiev";
    private String zip = "12340";
    private String city = "Kiev";
    private String country = "Украина";
    private String homePhone = "12345678";
    private String state = "Киевская область";
    private String addressTitle = "Kiev";

    public Address(String firstName, String lastName, String address, String zip, String city, String country, String homePhone, String state, String addressTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.homePhone = homePhone;
        this.state = state;
        this.addressTitle = addressTitle;
    }

    public Address() {
    }

}
