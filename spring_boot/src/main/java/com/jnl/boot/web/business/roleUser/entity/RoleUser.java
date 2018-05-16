package com.jnl.boot.web.business.roleUser.entity;

import java.util.Date;

public class RoleUser{

    private Integer id;//

    private Integer userId;//

    private Integer roleId;//

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
    public void setRoleId(Integer  roleId){
        this.roleId = roleId;
    }
    public Integer getRoleId(){
        return roleId;
    }
}