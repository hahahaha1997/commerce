package com.example.commerce.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class BorrowGood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowGoodId;

    @OneToOne
    private Good goodId;

    @ManyToOne
    private Brander branderId;

    @ManyToOne
    private Borrower borrowerId;

    @NotNull
    private Double borrowGoodPrice;

    @NotNull
    private Date borrowGoodTime;

    @NotNull
    private String borrowGoodStatus;

    private String borrowGoodDesc;//商品描述

    public BorrowGood() {
    }

    public Integer getBorrowGoodId() {
        return borrowGoodId;
    }

    public void setBorrowGoodId(Integer borrowGoodId) {
        this.borrowGoodId = borrowGoodId;
    }

    public Good getGoodId() {
        return goodId;
    }

    public void setGoodId(Good goodId) {
        this.goodId = goodId;
    }

    public Borrower getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Borrower borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Double getBorrowGoodPrice() {
        return borrowGoodPrice;
    }

    public void setBorrowGoodPrice(Double borrowGoodPrice) {
        this.borrowGoodPrice = borrowGoodPrice;
    }

    public Date getBorrowGoodTime() {
        return borrowGoodTime;
    }

    public void setBorrowGoodTime(Date borrowGoodTime) {
        this.borrowGoodTime = borrowGoodTime;
    }

    public String getBorrowGoodStatus() {
        return borrowGoodStatus;
    }

    public Brander getBranderId() {
        return branderId;
    }

    public void setBranderId(Brander branderId) {
        this.branderId = branderId;
    }

    public String getBorrowGoodDesc() {
        return borrowGoodDesc;
    }

    public void setBorrowGoodDesc(String borrowGoodDesc) {
        this.borrowGoodDesc = borrowGoodDesc;
    }

    public void setBorrowGoodStatus(String borrowGoodStatus) {
        this.borrowGoodStatus = borrowGoodStatus;
    }
}
