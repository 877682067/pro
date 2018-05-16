package com.jnl.boot.utils.convert;

public enum JavaType {
    String("String","char","varchar","tinyblob","tinytext","blob","text","mediumblob"
            ,"mediumtext","logngblob","longtext","varbinary","binary")
    ,Integer("Integer","tinyint","smallint","mediumint","int","integer"),Double("Double","double","decimal"),
    Date("Date","date","time","year","datatime","timestamp"),Long("Long","bigint"),Float("Float","float");
    private String[] sqlDataType;
    private String type;
    JavaType(String type, String... dataTypes){
        this.type = type;
        sqlDataType = dataTypes;
    }

    public String getType(String sqlDateType){
        sqlDateType = sqlDateType.toLowerCase();
        String type = "";
        for(int i =0;i<sqlDataType.length;i++){
            String currentType = sqlDataType[i];
            if(currentType.equals(sqlDateType)){
                type = this.type;
                break;
            }
        }
        return type;
    }
}
