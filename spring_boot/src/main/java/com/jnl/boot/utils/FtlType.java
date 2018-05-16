package com.jnl.boot.utils;

public enum FtlType {

    entity("entity","","entity")
    ,serviceImpl("service/impl","serviceImpl")
    ,service("service","service","service","I")
    ,controller("controller")
    ,mapperInterface("mapper","mapper","mapperInterface")
    ,mapper("mapper","mapper","mapper","","xml");

    private String suffix;
    private String dir;
    private String tempName;
    private String fileType;
    private String prefix;

    FtlType(String suffix){
        this(suffix,suffix);
    }
    FtlType(String dir,String suffix){
        this(dir,suffix,suffix);
    }

    FtlType(String dir, String suffix, String tempName) {
        this(dir,suffix,tempName,"");
    }
    FtlType(String dir,String suffix,String tempName,String prefix){
        this(dir,suffix,tempName,prefix,"java");
    }
    FtlType(String dir,String suffix,String tempName,String prefix,String fileType){
        this.dir = dir;
        this.suffix = suffix;
        this.tempName = tempName;
        this.prefix = prefix;
        this.fileType = fileType;
    }

    public String getTemplateName(){
        return tempName +".ftl";
    }
    private String getFileName(){
        return suffix+"."+fileType;
    }
    public String getDir(){
        return dir;
    }
    public String getFileName(String tableName){
        tableName = StringUtil.captureName(tableName);
        return prefix + tableName+StringUtil.captureName(this.getFileName());
    }
}
