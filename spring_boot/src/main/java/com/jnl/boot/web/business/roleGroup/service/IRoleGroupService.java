package com.jnl.boot.web.business.roleGroup.service;

import com.jnl.boot.web.business.roleGroup.entity.RoleGroup;
import java.util.List;

public interface IRoleGroupService{

    RoleGroup getRoleGroupById(Integer id);

    List<RoleGroup> list(RoleGroup roleGroup);

    int insert(RoleGroup roleGroup);

    int update(RoleGroup roleGroup);

}