package com.example.commerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Brander {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer branderId;

    @NotNull
    private String branderChineseName;

    private String branderEnglishName;


    private String branderIntorduction;
    @NotNull
    private String branderLawMan;
    @NotNull
    private Date breanderCreatTime;

    @NotNull
    private String branderPhone;

    @NotNull
    private String branderLoginName;


    @NotNull
    private  String branderLoginStatus;

    private String branderUploadStatus;

    private Double cash = 0.0;

    private String branderWalletPwd;

    @NotNull
    private String branderPwd;

    public Brander() {
    }

    public Integer getBranderId() {
        return branderId;
    }

    public void setBranderId(Integer branderId) {
        this.branderId = branderId;
    }

    public String getBranderChineseName() {
        return branderChineseName;
    }

    public void setBranderChineseName(String branderChineseName) {
        this.branderChineseName = branderChineseName;
    }

    public String getBranderEnglishName() {
        return branderEnglishName;
    }

    public void setBranderEnglishName(String branderEnglishName) {
        this.branderEnglishName = branderEnglishName;
    }

    public String getBranderIntorduction() {
        return branderIntorduction;
    }

    public void setBranderIntorduction(String branderIntorduction) {
        this.branderIntorduction = branderIntorduction;
    }

    public String getBranderLawMan() {
        return branderLawMan;
    }

    public void setBranderLawMan(String branderLawMan) {
        this.branderLawMan = branderLawMan;
    }

    public Date getBreanderCreatTime() {
        return breanderCreatTime;
    }

    public void setBreanderCreatTime(Date breanderCreatTime) {
        this.breanderCreatTime = breanderCreatTime;
    }

    public String getBranderPhone() {
        return branderPhone;
    }

    public void setBranderPhone(String branderPhone) {
        this.branderPhone = branderPhone;
    }

    public String getBranderLoginName() {
        return branderLoginName;
    }

    public void setBranderLoginName(String branderLoginName) {
        this.branderLoginName = branderLoginName;
    }

    public String getBranderLoginStatus() {
        return branderLoginStatus;
    }

    public void setBranderLoginStatus(String branderLoginStatus) {
        this.branderLoginStatus = branderLoginStatus;
    }

    public String getBranderUploadStatus() {
        return branderUploadStatus;
    }

    public void setBranderUploadStatus(String branderUploadStatus) {
        this.branderUploadStatus = branderUploadStatus;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String  getBranderWalletPwd() {
        return branderWalletPwd;
    }

    public void setBranderWalletPwd(String branderWalletPwd) {
        this.branderWalletPwd = branderWalletPwd;
    }

    public String getBranderPwd() {
        return branderPwd;
    }

    public void setBranderPwd(String branderPwd) {
        this.branderPwd = branderPwd;
    }
}
