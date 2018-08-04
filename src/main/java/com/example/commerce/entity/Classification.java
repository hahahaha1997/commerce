package com.example.commerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ClassifyId;

    @NotNull
    private Integer ClassifyParentId;

    @NotNull
    private  String ClassifyDescription;//类别名称

    @NotNull
    private String ClassifyPath;//类别全路径

    @NotNull
    private Date ClassifyCreateTime;//创建时间

    @NotNull
    private String ClassifyStatus;

    public Classification() {
    }

    public Integer getClassifyId() {
        return ClassifyId;
    }

    public void setClassifyId(Integer classifyId) {
        ClassifyId = classifyId;
    }

    public Integer getClassifyParentId() {
        return ClassifyParentId;
    }

    public void setClassifyParentId(Integer classifyParentId) {
        ClassifyParentId = classifyParentId;
    }

    public String getClassifyDescription() {
        return ClassifyDescription;
    }

    public void setClassifyDescription(String classifyDescription) {
        ClassifyDescription = classifyDescription;
    }

    public String getClassifyPath() {
        return ClassifyPath;
    }

    public void setClassifyPath(String classifyPath) {
        ClassifyPath = classifyPath;
    }

    public Date getClassifyCreateTime() {
        return ClassifyCreateTime;
    }

    public void setClassifyCreateTime(Date classifyCreateTime) {
        ClassifyCreateTime = classifyCreateTime;
    }

    public String getClassifyStatus() {
        return ClassifyStatus;
    }

    public void setClassifyStatus(String classifyStatus) {
        ClassifyStatus = classifyStatus;
    }
}
