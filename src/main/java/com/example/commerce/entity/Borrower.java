package com.example.commerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowerId;

    @NotNull
    private String borrowerName;

    private String borrowerDec;//网站描述
    @NotNull
    private String borrowerWeb;//网站名称
    @NotNull
    private Integer borrowerPhone;
    @NotNull
    private String borrowerLoginName;

    @NotNull
    private String borrowerPwd;
    @NotNull
    private String borrowerLoginStatus;

    private String borrowerUploadStatus;
    @NotNull
    private Date borrowerTime;//注册时间

    @NotNull
    private String borrowerWalletPwd;

    private Double cash = 0.0;

    public Borrower() {
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerDec() {
        return borrowerDec;
    }

    public void setBorrowerDec(String borrowerDec) {
        this.borrowerDec = borrowerDec;
    }

    public Integer getBorrowerPhone() {
        return borrowerPhone;
    }

    public void setBorrowerPhone(Integer borrowerPhone) {
        this.borrowerPhone = borrowerPhone;
    }

    public String getBorrowerWalletPwd() {
        return borrowerWalletPwd;
    }

    public void setBorrowerWalletPwd(String borrowerWalletPwd) {
        this.borrowerWalletPwd = borrowerWalletPwd;
    }

    public String getBorrowerPwd() {
        return borrowerPwd;
    }

    public void setBorrowerPwd(String borrowerPwd) {
        this.borrowerPwd = borrowerPwd;
    }

    public String getBorrowerWeb() {
        return borrowerWeb;
    }

    public void setBorrowerWeb(String borrowerWeb) {
        this.borrowerWeb = borrowerWeb;
    }

    public String getBorrowerLoginName() {
        return borrowerLoginName;
    }

    public void setBorrowerLoginName(String borrowerLoginName) {
        this.borrowerLoginName = borrowerLoginName;
    }

    public String getBorrowerLoginStatus() {
        return borrowerLoginStatus;
    }

    public void setBorrowerLoginStatus(String borrowerLoginStatus) {
        this.borrowerLoginStatus = borrowerLoginStatus;
    }

    public String getBorrowerUploadStatus() {
        return borrowerUploadStatus;
    }

    public void setBorrowerUploadStatus(String borrowerUploadStatus) {
        this.borrowerUploadStatus = borrowerUploadStatus;
    }

    public Date getBorrowerTime() {
        return borrowerTime;
    }

    public void setBorrowerTime(Date borrowerTime) {
        this.borrowerTime = borrowerTime;
    }



}
