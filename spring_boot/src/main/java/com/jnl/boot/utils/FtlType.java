package com.jnl.boot.utils;

public enum FtlType {

    entity("entity"),service("service"),controller("controller"),serviceImpl("serviceImpl")
    ,mapperInterface("mapperInterface"),mapper("mapper");

    private String name;

    FtlType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
