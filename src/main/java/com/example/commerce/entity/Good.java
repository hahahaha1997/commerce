package com.example.commerce.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Good {

    @NotNull
    private String goodName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goodId;

    @OneToOne
    private  Classification classificationId;//商品分类ID


    private String goodImg;

    private String goodStatus;
    @NotNull
    private Double goodPrice;//进价
    @NotNull
    private Integer goodStock;//库存

    @ManyToOne
    private Brand brandId;

    @ManyToOne
    private Brander branderId;

    @OneToOne
    private Borrower borrowered;


    private Integer  goodClassifyId;//末级ID

    @NotNull
    private Double goodAdvicePrice;//建议零售价

    private Integer goodWarning;//库存预警

    public Good() {
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    public String getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(String goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getGoodStock() {
        return goodStock;
    }

    public void setGoodStock(Integer goodStock) {
        this.goodStock = goodStock;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public Borrower getBorrowered() {
        return borrowered;
    }

    public void setBorrowered(Borrower borrowered) {
        this.borrowered = borrowered;
    }

    public Integer getGoodClassifyId() {
        return goodClassifyId;
    }

    public void setGoodClassifyId(Integer goodClassifyId) {
        this.goodClassifyId = goodClassifyId;
    }

    public Classification getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Classification classificationId) {
        this.classificationId = classificationId;
    }

    public Brander getBranderId() {
        return branderId;
    }

    public void setBranderId(Brander branderId) {
        this.branderId = branderId;
    }

    public Double getGoodAdvicePrice() {
        return goodAdvicePrice;
    }

    public void setGoodAdvicePrice(Double goodAdvicePrice) {
        this.goodAdvicePrice = goodAdvicePrice;
    }

    public Integer getGoodWarning() {
        return goodWarning;
    }

    public void setGoodWarning(Integer goodWarning) {
        this.goodWarning = goodWarning;
    }
}
