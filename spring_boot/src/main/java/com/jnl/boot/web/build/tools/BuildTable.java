package com.jnl.boot.web.build.tools;

import com.jnl.boot.utils.FreemakerUtils;
import com.jnl.boot.utils.FtlType;
import com.jnl.boot.web.build.entity.Table;
import freemarker.template.TemplateException;

import java.io.IOException;

public class BuildTable {

    private Table table;

    public BuildTable(){
    }

    public boolean build(Table table){
        this.table = table;
        try {
            this.buildClass();
            this.buildMapper();
            this.buildView();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void buildView() {

    }

    private void buildMapper() {
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

    private void buildService() {

    }
    private void buildMapperInterFace() {
    }
    private void buildController() {
    }

    public BuildTable setTable(Table table){
        this.table = table;
        return this;
    }
}
