package com.jnl.boot.web.business.resource.entity;

import java.util.Date;

public class Resource{

    private Integer id;//

    private String name;//

    private String uri;//

    private Integer parent;//

    private String creator;//

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
    public void setUri(String  uri){
        this.uri = uri;
    }
    public String getUri(){
        return uri;
    }
    public void setParent(Integer  parent){
        this.parent = parent;
    }
    public Integer getParent(){
        return parent;
    }
    public void setCreator(String  creator){
        this.creator = creator;
    }
    public String getCreator(){
        return creator;
    }
}