package com.jnl.boot.web.build.service;

import com.jnl.boot.web.build.entity.Table;
import com.jnl.boot.web.build.vo.GatherBuildInfo;

public interface BuildService {

    Table build(GatherBuildInfo info);

}
