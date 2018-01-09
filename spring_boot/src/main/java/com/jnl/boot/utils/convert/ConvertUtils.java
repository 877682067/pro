package com.jnl.boot.utils.convert;

public class ConvertUtils {


    public static String convertDataType(String sqlType){
        JavaType[] types = JavaType.values();
        for(int i = 0;i<types.length;i++){
            String type = types[i].getType(sqlType);
            if(!"".equals(type)){
                return type;
            }
        }
        return "String";
    }

    public  static  void main(String[] args){
       System.out.println( ConvertUtils.convertDataType("double"));
    }
}
