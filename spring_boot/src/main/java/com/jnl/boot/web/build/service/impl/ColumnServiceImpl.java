package com.jnl.boot.web.build.service.impl;

import com.jnl.boot.web.build.entity.Column;
import com.jnl.boot.web.build.mapper.ColumnMapper;
import com.jnl.boot.web.build.service.ColumnService;
import com.jnl.boot.web.build.vo.GatherBuildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("columnService")
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    public List<Column> getTableColumns(GatherBuildInfo info) {
        Column column = new Column();
        column.setTableName(info.getTableName());
        return columnMapper.getColumnsByTable(column);
    }
}


