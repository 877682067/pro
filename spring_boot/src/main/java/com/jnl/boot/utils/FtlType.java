package com.jnl.boot.utils;

public enum FtlType {

    entity("entity","entity"),service("service","service"),controller("controller","controller"),serviceImpl("serviceImpl","service/impl")
    ,mapperInterface("mapperInterface","mapper"),mapper("mapper","mapper","xml");

    private String name;
    private String dir;
    private String fileType;

    FtlType(String name,String dir){
        this(name,dir,"java");
    }
    FtlType(String name,String dir,String fileType){
        this.name = name;
        this.dir = dir;
        this.fileType = fileType;
    }
    public String getName(){
        return name+".ftl";
    }
    public String getDir(){
        return dir;
    }
    public String getFileName(String tableName){
        tableName = StringUtil.captureName(tableName);
        if(name.equals(entity))
            return tableName;
        return tableName+StringUtil.captureName(name);
    }
}
