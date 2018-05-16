package com.jnl.boot.web.business.role.service.impl;

import com.jnl.boot.web.business.role.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.role.entity.Role;
import com.jnl.boot.web.business.role.mapper.RoleMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role getRoleById(Integer id){
        return roleMapper.getRoleById(id);
    }

    @Override
    public List<Role> list(Role role){
        return roleMapper.list(role);
    }

    @Override
    public int insert(Role role){
        return roleMapper.insert(role);
    }

    public int update(Role role){
        return roleMapper.update(role);
    }

}