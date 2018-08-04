package com.example.commerce.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.example.commerce.entity.Customer;

import java.util.Date;


@Entity
public class NutOrderForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nutOrderFormId;

    @ManyToOne
    private Customer customerId;

    @ManyToOne
    private Brander branderId;



    @ManyToOne
    private Borrower borrowerId;

    @NotNull
    private Date nutOrderFormCreateTime;//创建时间

    @NotNull
    private  Date nutOrderFormPayTime;//支付时间

    @OneToOne
    private  ShippingAddress shippingAddressId;

    @OneToOne
    private Pay payId;

    @NotNull
    private Double nutOrderFormTotalPrice;

    @NotNull
    private  String nutOrderFormStatus;//订单状态




    public NutOrderForm() {

    }

    public Brander getBranderId() {
        return branderId;
    }

    public void setBranderId(Brander branderId) {
        this.branderId = branderId;
    }
    public Integer getNutOrderFormId() {
        return nutOrderFormId;
    }

    public void setNutOrderFormId(Integer nutOrderFormId) {
        this.nutOrderFormId = nutOrderFormId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Borrower getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Borrower borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Date getNutOrderFormCreateTime() {
        return nutOrderFormCreateTime;
    }

    public void setNutOrderFormCreateTime(Date nutOrderFormCreateTime) {
        this.nutOrderFormCreateTime = nutOrderFormCreateTime;
    }

    public Date getNutOrderFormPayTime() {
        return nutOrderFormPayTime;
    }

    public void setNutOrderFormPayTime(Date nutOrderFormPayTime) {
        this.nutOrderFormPayTime = nutOrderFormPayTime;
    }

    public ShippingAddress getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(ShippingAddress shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Pay getPayId() {
        return payId;
    }

    public void setPayId(Pay payId) {
        this.payId = payId;
    }

    public Double getNutOrderFormTotalPrice() {
        return nutOrderFormTotalPrice;
    }

    public void setNutOrderFormTotalPrice(Double nutOrderFormTotalPrice) {
        this.nutOrderFormTotalPrice = nutOrderFormTotalPrice;
    }

    public String getNutOrderFormStatus() {
        return nutOrderFormStatus;
    }

    public void setNutOrderFormStatus(String nutOrderFormStatus) {
        this.nutOrderFormStatus = nutOrderFormStatus;
    }
}
