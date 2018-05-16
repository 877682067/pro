package com.jnl.boot.web.business.resourceRole.mapper;

import com.jnl.boot.web.business.resourceRole.entity.ResourceRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceRoleMapper{

    ResourceRole getResourceRoleById(Integer id);

    List<ResourceRole> list(ResourceRole resourceRole);

    int insert(ResourceRole resourceRole);

    int insertList(@Param("list") List<ResourceRole> resourceRoleList);

    int update(ResourceRole resourceRole);

}