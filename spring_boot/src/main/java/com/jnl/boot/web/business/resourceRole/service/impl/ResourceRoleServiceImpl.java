package com.jnl.boot.web.business.resourceRole.service.impl;

import com.jnl.boot.web.business.resourceRole.service.IResourceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.resourceRole.entity.ResourceRole;
import com.jnl.boot.web.business.resourceRole.mapper.ResourceRoleMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("resourceRoleService")
public class ResourceRoleServiceImpl implements IResourceRoleService {
    @Autowired
    private ResourceRoleMapper resourceRoleMapper;
    @Override
    public ResourceRole getResourceRoleById(Integer id){
        return resourceRoleMapper.getResourceRoleById(id);
    }

    @Override
    public List<ResourceRole> list(ResourceRole resourceRole){
        return resourceRoleMapper.list(resourceRole);
    }

    @Override
    public int insert(ResourceRole resourceRole){
        return resourceRoleMapper.insert(resourceRole);
    }

    public int update(ResourceRole resourceRole){
        return resourceRoleMapper.update(resourceRole);
    }

}