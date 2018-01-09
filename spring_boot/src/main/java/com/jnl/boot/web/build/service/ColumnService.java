package com.jnl.boot.web.build.service;

import com.jnl.boot.web.build.entity.Column;
import com.jnl.boot.web.build.vo.GatherBuildInfo;

import java.util.List;

public interface ColumnService {

   List<Column> getTableColumns(GatherBuildInfo info);

}
