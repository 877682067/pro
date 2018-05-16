package com.jnl.boot.web.build.tools;

import com.jnl.boot.utils.FreemakerUtils;
import com.jnl.boot.utils.FtlType;
import com.jnl.boot.web.build.entity.Table;
import freemarker.template.TemplateException;

import java.io.IOException;

public class CodeBuilder {

    private Table table;

    public CodeBuilder(){
    }

    public  boolean build(Table table) throws IOException, TemplateException {
        this.table = table;
        this.buildClass();
        this.buildMapper();
        //this.buildView();
        return true;
    }

    private void buildView() {

    }

    private void buildMapper() throws IOException, TemplateException {
        FreemakerUtils.createFile(table, FtlType.mapper);
    }

    private void buildClass() throws IOException, TemplateException {
        this.buildEntity();
        this.buildMapperInterFace();
        this.buildController();
        this.buildService();
    }

    private void buildEntity() throws IOException, TemplateException {
        FreemakerUtils.createFile(table, FtlType.entity);
    }

    private void buildService() throws IOException, TemplateException {
        FreemakerUtils.createFile(table, FtlType.service);
        FreemakerUtils.createFile(table, FtlType.serviceImpl);
    }
    private void buildMapperInterFace()throws IOException, TemplateException {
        FreemakerUtils.createFile(table, FtlType.mapperInterface);
    }
    private void buildController() throws IOException, TemplateException {
        FreemakerUtils.createFile(table, FtlType.controller);
    }

    public CodeBuilder setTable(Table table){
        this.table = table;
        return this;
    }

    public static String getContextPath(Table table) {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        path += table.getPackag().replace(".","/");
        path +="/"+table.getMark();
        return path;
    }
}
