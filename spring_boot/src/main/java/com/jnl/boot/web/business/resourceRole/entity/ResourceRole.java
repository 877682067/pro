package com.jnl.boot.web.business.resourceRole.entity;

import java.util.Date;

public class ResourceRole{

    private Integer id;//

    private Integer roleId;//

    private Integer resourceId;//

    public void setId(Integer  id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setRoleId(Integer  roleId){
        this.roleId = roleId;
    }
    public Integer getRoleId(){
        return roleId;
    }
    public void setResourceId(Integer  resourceId){
        this.resourceId = resourceId;
    }
    public Integer getResourceId(){
        return resourceId;
    }
}