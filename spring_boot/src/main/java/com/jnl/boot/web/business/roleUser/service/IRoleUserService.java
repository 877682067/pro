package com.jnl.boot.web.business.roleUser.service;

import com.jnl.boot.web.business.roleUser.entity.RoleUser;
import java.util.List;

public interface IRoleUserService{

    RoleUser getRoleUserById(Integer id);

    List<RoleUser> list(RoleUser roleUser);

    int insert(RoleUser roleUser);

    int update(RoleUser roleUser);

}