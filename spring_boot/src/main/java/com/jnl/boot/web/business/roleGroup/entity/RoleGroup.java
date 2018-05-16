package com.jnl.boot.web.business.roleGroup.entity;

import java.util.Date;

public class RoleGroup{

    private Integer id;//

    private Integer groupId;//

    private Integer roleId;//

    public void setId(Integer  id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setGroupId(Integer  groupId){
        this.groupId = groupId;
    }
    public Integer getGroupId(){
        return groupId;
    }
    public void setRoleId(Integer  roleId){
        this.roleId = roleId;
    }
    public Integer getRoleId(){
        return roleId;
    }
}