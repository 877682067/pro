package com.jnl.boot.web.business.resourceUser.entity;

import java.util.Date;

public class ResourceUser{

    private Integer id;//

    private Integer userId;//

    private Integer resourceId;//

    public void setId(Integer  id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setUserId(Integer  userId){
        this.userId = userId;
    }
    public Integer getUserId(){
        return userId;
    }
    public void setResourceId(Integer  resourceId){
        this.resourceId = resourceId;
    }
    public Integer getResourceId(){
        return resourceId;
    }
}