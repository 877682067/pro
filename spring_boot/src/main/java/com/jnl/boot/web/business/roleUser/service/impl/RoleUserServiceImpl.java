package com.jnl.boot.web.business.roleUser.service.impl;

import com.jnl.boot.web.business.roleUser.service.IRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.roleUser.entity.RoleUser;
import com.jnl.boot.web.business.roleUser.mapper.RoleUserMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("roleUserService")
public class RoleUserServiceImpl implements IRoleUserService {
    @Autowired
    private RoleUserMapper roleUserMapper;
    @Override
    public RoleUser getRoleUserById(Integer id){
        return roleUserMapper.getRoleUserById(id);
    }

    @Override
    public List<RoleUser> list(RoleUser roleUser){
        return roleUserMapper.list(roleUser);
    }

    @Override
    public int insert(RoleUser roleUser){
        return roleUserMapper.insert(roleUser);
    }

    public int update(RoleUser roleUser){
        return roleUserMapper.update(roleUser);
    }

}