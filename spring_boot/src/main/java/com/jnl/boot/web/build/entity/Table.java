package com.jnl.boot.web.build.entity;

import com.jnl.boot.utils.convert.DataBaseNameConvert;

import java.util.Date;
import java.util.List;

public class Table {

    private String name;//字符替换后的名称

    private String baseName;//数据库表名称

    private String dataBase;

    private String packag;

    private List<Column> columns;

    private String mark;

    public Table(){
        this.mark = this.getRodomFileName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public String getPackag() {
        return packag;
    }

    public void setPackag(String packag) {
        this.packag = packag;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
        this.name= DataBaseNameConvert.convert(baseName);
    }

    public String getMark(){
        return  this.mark;
    }
    public String getRodomFileName() {
        StringBuilder fileName = new StringBuilder("tempFN");
        long now = new Date().getTime();
        return fileName.append(now).toString();
    }
}
