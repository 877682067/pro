package com.jnl.boot.web.build.service.impl;

import com.jnl.boot.web.build.entity.Table;
import com.jnl.boot.web.build.service.BuildService;
import com.jnl.boot.web.build.service.TableService;
import com.jnl.boot.web.build.tools.BuildTable;
import com.jnl.boot.web.build.vo.GatherBuildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("buildService")
public class BuildServiceImpl implements BuildService{

    @Autowired
    private TableService tableService;

    @Override
    public boolean build(GatherBuildInfo info) {
        Table table = tableService.getTable(info);
        BuildTable build = new BuildTable();
        build.build(table);
        return false;
    }
}
