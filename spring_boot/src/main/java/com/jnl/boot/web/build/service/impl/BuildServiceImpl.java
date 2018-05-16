package com.jnl.boot.web.build.service.impl;

import com.jnl.boot.web.build.entity.Table;
import com.jnl.boot.web.build.service.BuildService;
import com.jnl.boot.web.build.service.TableService;
import com.jnl.boot.web.build.tools.CodeBuilder;
import com.jnl.boot.web.build.vo.GatherBuildInfo;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("buildService")
public class BuildServiceImpl implements BuildService{

    @Autowired
    private TableService tableService;

    @Override
    public Table build(GatherBuildInfo info) {
        Table table = tableService.getTable(info);
        table.setPackag(info.getPackag());
        CodeBuilder build = new CodeBuilder();
        try {
            build.build(table);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return table;
    }
}
