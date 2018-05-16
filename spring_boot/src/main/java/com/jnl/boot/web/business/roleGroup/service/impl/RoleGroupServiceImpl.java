package com.jnl.boot.web.business.roleGroup.service.impl;

import com.jnl.boot.web.business.roleGroup.service.IRoleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.roleGroup.entity.RoleGroup;
import com.jnl.boot.web.business.roleGroup.mapper.RoleGroupMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("roleGroupService")
public class RoleGroupServiceImpl implements IRoleGroupService {
    @Autowired
    private RoleGroupMapper roleGroupMapper;
    @Override
    public RoleGroup getRoleGroupById(Integer id){
        return roleGroupMapper.getRoleGroupById(id);
    }

    @Override
    public List<RoleGroup> list(RoleGroup roleGroup){
        return roleGroupMapper.list(roleGroup);
    }

    @Override
    public int insert(RoleGroup roleGroup){
        return roleGroupMapper.insert(roleGroup);
    }

    public int update(RoleGroup roleGroup){
        return roleGroupMapper.update(roleGroup);
    }

}