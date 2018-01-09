package com.jnl.boot.web.build.entity;

import java.util.List;

public class Table {

    private String name;

    private String dataBase;

    private String packag;

    private List<Column> columns;


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
}
