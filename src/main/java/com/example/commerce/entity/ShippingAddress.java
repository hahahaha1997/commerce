package com.example.commerce.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ShippingAddressId;

    @OneToOne
    private Customer customerId;

    @NotNull
    private String customerName;

    @NotNull
    private  String shippingAddress;

    @NotNull
    private String customerPhone;

    public ShippingAddress() {
    }

    public Integer getShippingAddressId() {
        return ShippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        ShippingAddressId = shippingAddressId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
