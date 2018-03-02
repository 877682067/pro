package com.jnl.boot.web.build.service.impl;

import com.jnl.boot.web.build.entity.Column;
import com.jnl.boot.web.build.entity.Table;
import com.jnl.boot.web.build.service.ColumnService;
import com.jnl.boot.web.build.service.TableService;
import com.jnl.boot.web.build.vo.GatherBuildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tableService")
public class TableServiceImpl implements TableService {

    @Autowired
    private ColumnService columnService;

    @Override
    public Table getTable(GatherBuildInfo info) {
        List<Column> tableColumns = columnService.getTableColumns(info);
        Table table = new Table();
        table.setDataBase(info.getDataBase().getDataBase());
        table.setBaseName(info.getTableName());
        table.setColumns(tableColumns);
        return table;
    }
}
