package com.jnl.boot.web.business.resource.service.impl;

import com.jnl.boot.web.business.resource.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.resource.entity.Resource;
import com.jnl.boot.web.business.resource.mapper.ResourceMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("resourceService")
public class ResourceServiceImpl implements IResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public Resource getResourceById(Integer id){
        return resourceMapper.getResourceById(id);
    }

    @Override
    public List<Resource> list(Resource resource){
        return resourceMapper.list(resource);
    }

    @Override
    public int insert(Resource resource){
        return resourceMapper.insert(resource);
    }

    public int update(Resource resource){
        return resourceMapper.update(resource);
    }

}