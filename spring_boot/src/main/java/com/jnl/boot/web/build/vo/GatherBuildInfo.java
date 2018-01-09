package com.jnl.boot.web.build.vo;

public class GatherBuildInfo {

    private String tableName;

    private DataBaseConnector dataBase;

    private String fileUrl;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public DataBaseConnector getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBaseConnector dataBase) {
        this.dataBase = dataBase;
    }
}
