package com.jnl.boot.web.business.userGroup.entity;

import java.util.Date;

public class UserGroup{

    private Integer id;//

    private String name;//

    private String discription;//

    public void setId(Integer  id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setName(String  name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDiscription(String  discription){
        this.discription = discription;
    }
    public String getDiscription(){
        return discription;
    }
}