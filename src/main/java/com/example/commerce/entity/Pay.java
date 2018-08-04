package com.example.commerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer PayId;

    private String Payname;

    public Pay() {
    }

    public Integer getPayId() {
        return PayId;
    }

    public void setPayId(Integer payId) {
        PayId = payId;
    }

    public String getPayname() {
        return Payname;
    }

    public void setPayname(String payname) {
        Payname = payname;
    }
}
