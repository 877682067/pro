package com.jnl.boot.web.business.resource.service;

import com.jnl.boot.web.business.resource.entity.Resource;
import java.util.List;

public interface IResourceService{

    Resource getResourceById(Integer id);

    List<Resource> list(Resource resource);

    int insert(Resource resource);

    int update(Resource resource);

}