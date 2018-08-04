package com.example.commerce.entity;

import ch.qos.logback.classic.db.names.ColumnName;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="adminName")})
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer adminId;

    @NotNull
    private String adminName;

    @NotNull
    private String password;

    @NotNull
    private Integer adminPower;//权限等级，0-10，0为superAdmin,1-9为normalAdmin

    public Admin() {
    }

    public Integer getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(Integer adminPower) {
        this.adminPower = adminPower;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
