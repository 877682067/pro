package com.jnl.boot.web.business.user.entity;

import java.util.Date;

public class User{


    private Integer id;//

    private String name;//

    private String password;//

    private String portrait;//

    private String nickname;//

    private Date birth;//

    private String familyName;//

    private String lastName;//
    private String salt;//


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
    public void setPassword(String  password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setPortrait(String  portrait){
        this.portrait = portrait;
    }
    public String getPortrait(){
        return portrait;
    }
    public void setNickname(String  nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return nickname;
    }
    public void setBirth(Date  birth){
        this.birth = birth;
    }
    public Date getBirth(){
        return birth;
    }
    public void setFamilyName(String  familyName){
        this.familyName = familyName;
    }
    public String getFamilyName(){
        return familyName;
    }
    public void setLastName(String  lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}