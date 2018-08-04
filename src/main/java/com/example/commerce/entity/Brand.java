package com.example.commerce.entity;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;

    @ManyToOne
    private Brander branderId;

    private String goodImg;


    @NotNull
    private  String brandChineseName;

    @NotNull
    private String brandEnglishName;

    @NotNull
    private String brandCreatePeo;

    @NotNull
    private Date brandCreateTime;

    @NotNull
    private String brandStatus;

    public Brand() {
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }


    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    public Brander getBranderId() {
        return branderId;
    }

    public void setBranderId(Brander branderId) {
        this.branderId = branderId;
    }

    public String getBrandChineseName() {
        return brandChineseName;
    }

    public void setBrandChineseName(String brandChineseName) {
        this.brandChineseName = brandChineseName;
    }

    public String getBrandEnglishName() {
        return brandEnglishName;
    }

    public void setBrandEnglishName(String brandEnglishName) {
        this.brandEnglishName = brandEnglishName;
    }

    public String getBrandCreatePeo() {
        return brandCreatePeo;
    }

    public void setBrandCreatePeo(String brandCreatePeo) {
        this.brandCreatePeo = brandCreatePeo;
    }

    public Date getBrandCreateTime() {
        return brandCreateTime;
    }

    public void setBrandCreateTime(Date brandCreateTime) {
        this.brandCreateTime = brandCreateTime;
    }

    public String getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(String brandStatus) {
        this.brandStatus = brandStatus;
    }
}
