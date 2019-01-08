package me.whiteship.demospringdata;

/*
Account에 속한 데이터의 한 종류
 */

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

}
