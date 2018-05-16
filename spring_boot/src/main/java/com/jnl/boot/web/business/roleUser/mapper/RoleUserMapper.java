package com.jnl.boot.web.business.roleUser.mapper;

import com.jnl.boot.web.business.roleUser.entity.RoleUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleUserMapper{

    RoleUser getRoleUserById(Integer id);

    List<RoleUser> list(RoleUser roleUser);

    int insert(RoleUser roleUser);

    int insertList(@Param("list") List<RoleUser> roleUserList);

    int update(RoleUser roleUser);

}