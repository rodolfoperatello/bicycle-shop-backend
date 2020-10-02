package br.com.exactalabs.bicycleshop.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder {


    private Long id;
    private String name;
    private String lastName;
    private String cpf;
    private String email;
    private String mainPhone;
    private String secondaryPhone;
    private LocalDate birthday;
    private List<Address> addressList = new ArrayList<>();


    public CustomerBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder setName(String name){
        this.name = name;
        return this;
    }

    public CustomerBuilder setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder setCpf(String cpf){
        this.cpf = cpf;
        return this;
    }

    public CustomerBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public CustomerBuilder setMainPhone(String mainPhone){
        this.mainPhone = mainPhone;
        return this;
    }

    public CustomerBuilder setSecondaryPhone(String secondaryPhone){
        this.secondaryPhone = secondaryPhone;
        return this;
    }

    public CustomerBuilder setBirthday(LocalDate birthday){
        this.birthday = birthday;
        return this;
    }

    public CustomerBuilder setAdressList(List<Address> adressList){
        this.addressList = addressList;
        return this;
    }

    public Customer createCustomer(){
        return new Customer(name, lastName, cpf, mainPhone, secondaryPhone, birthday, email);
    }



}
