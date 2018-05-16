package com.jnl.boot.web.business.resourceUser.service;

import com.jnl.boot.web.business.resourceUser.entity.ResourceUser;
import java.util.List;

public interface IResourceUserService{

    ResourceUser getResourceUserById(Integer id);

    List<ResourceUser> list(ResourceUser resourceUser);

    int insert(ResourceUser resourceUser);

    int update(ResourceUser resourceUser);

}