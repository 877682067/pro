package com.jnl.boot.web.business.resourceRole.service;

import com.jnl.boot.web.business.resourceRole.entity.ResourceRole;
import java.util.List;

public interface IResourceRoleService{

    ResourceRole getResourceRoleById(Integer id);

    List<ResourceRole> list(ResourceRole resourceRole);

    int insert(ResourceRole resourceRole);

    int update(ResourceRole resourceRole);

}