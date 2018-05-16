package com.jnl.boot.web.business.resourceUser.service.impl;

import com.jnl.boot.web.business.resourceUser.service.IResourceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.resourceUser.entity.ResourceUser;
import com.jnl.boot.web.business.resourceUser.mapper.ResourceUserMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("resourceUserService")
public class ResourceUserServiceImpl implements IResourceUserService {
    @Autowired
    private ResourceUserMapper resourceUserMapper;
    @Override
    public ResourceUser getResourceUserById(Integer id){
        return resourceUserMapper.getResourceUserById(id);
    }

    @Override
    public List<ResourceUser> list(ResourceUser resourceUser){
        return resourceUserMapper.list(resourceUser);
    }

    @Override
    public int insert(ResourceUser resourceUser){
        return resourceUserMapper.insert(resourceUser);
    }

    public int update(ResourceUser resourceUser){
        return resourceUserMapper.update(resourceUser);
    }

}