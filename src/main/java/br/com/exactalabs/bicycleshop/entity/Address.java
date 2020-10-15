package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "A rua não pode ser vazio")
    private String street;
    @NotBlank(message = "O bairro não pode ser vazio")
    private String district;
    @NotBlank(message = "A cidade não pode ser vazio")
    private String city;
    @NotBlank(message = "O estado não pode ser vazio")
    private String state;
    @NotBlank(message = "O CEP não pode ser vazio")
    private String zipCode;
    @NotBlank(message = "O número não pode ser vazio")
    private String number;
    private String complement;


    public Address(){

    }

    private Address(String street, String district, String city, String state, String zipcode, String number, String complement) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
        this.number = number;
        this.complement = complement;
    }

    public static class AddressBuilder {

        private String street;
        private String district;
        private String city;
        private String state;
        private String zipCode;
        private String number;
        private String complement;

        public AddressBuilder(){

        }

        public AddressBuilder street(String street){
            this.street = street;
            return this;
        }

        public AddressBuilder district(String district){
            this.district = district;
            return this;
        }

        public AddressBuilder city(String city){
            this.city = city;
            return this;
        }

        public AddressBuilder state(String state){
            this.state = state;
            return this;
        }

        public AddressBuilder zipCode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }

        public AddressBuilder number(String number){
            this.number = number;
            return this;
        }

        public AddressBuilder complement(String complement){
            this.complement = complement;
            return this;
        }

        public Address createAddress(){
            return new Address(street, district, city, state, zipCode, number, complement);
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipCode + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }


}

