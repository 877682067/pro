package com.jnl.boot.web.business.roleGroup.mapper;

import com.jnl.boot.web.business.roleGroup.entity.RoleGroup;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleGroupMapper{

    RoleGroup getRoleGroupById(Integer id);

    List<RoleGroup> list(RoleGroup roleGroup);

    int insert(RoleGroup roleGroup);

    int insertList(@Param("list") List<RoleGroup> roleGroupList);

    int update(RoleGroup roleGroup);

}