package com.jnl.boot.web.business.role.service;

import com.jnl.boot.web.business.role.entity.Role;
import java.util.List;

public interface IRoleService{

    Role getRoleById(Integer id);

    List<Role> list(Role role);

    int insert(Role role);

    int update(Role role);

}