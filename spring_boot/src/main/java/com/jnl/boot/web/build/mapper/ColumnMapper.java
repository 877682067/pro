package com.jnl.boot.web.build.mapper;


import com.jnl.boot.web.build.entity.Column;

import java.util.List;

public interface ColumnMapper {

    List<Column> list(Column info);

    List<Column> getColumnsByTable(Column column);
}
