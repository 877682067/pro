package com.jnl.boot.web.business.role.mapper;

import com.jnl.boot.web.business.role.entity.Role;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper{

    Role getRoleById(Integer id);

    List<Role> list(Role role);

    int insert(Role role);

    int insertList(@Param("list") List<Role> roleList);

    int update(Role role);

}