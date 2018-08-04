package com.example.commerce.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LoginLog {

    @Id
    @GeneratedValue
    private  Integer logId;



}
