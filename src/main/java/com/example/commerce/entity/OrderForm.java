package com.example.commerce.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class OrderForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer orderFormId;

    @OneToOne
    private Good goodId;

    @ManyToOne
    private NutOrderForm nutOrderFormId;

    @NotNull
    private Double goodFormPrice;

    @NotNull
    private Integer goodFormNum;

    private Double goodTotalPrice;

    @NotNull
    private Date goodFormCreateTime;

    public OrderForm() {
    }

    public Integer getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(Integer orderFormId) {
        this.orderFormId = orderFormId;
    }

    public Good getGoodId() {
        return goodId;
    }

    public void setGoodId(Good goodId) {
        this.goodId = goodId;
    }

    public NutOrderForm getNutOrderFormId() {
        return nutOrderFormId;
    }

    public void setNutOrderFormId(NutOrderForm nutOrderFormId) {
        this.nutOrderFormId = nutOrderFormId;
    }

    public Date getGoodFormCreateTime() {
        return goodFormCreateTime;
    }

    public void setGoodFormCreateTime(Date goodFormCreateTime) {
        this.goodFormCreateTime = goodFormCreateTime;
    }

    public Double getGoodFormPrice() {
        return goodFormPrice;
    }

    public void setGoodFormPrice(Double goodFormPrice) {
        this.goodFormPrice = goodFormPrice;
    }

    public Integer getGoodFormNum() {
        return goodFormNum;
    }

    public void setGoodFormNum(Integer goodFormNum) {
        this.goodFormNum = goodFormNum;
    }

    public Double getGoodTotalPrice() {
        return goodTotalPrice;
    }

    public void setGoodTotalPrice(Double goodTotalPrice) {
        this.goodTotalPrice = goodTotalPrice;
    }
}
