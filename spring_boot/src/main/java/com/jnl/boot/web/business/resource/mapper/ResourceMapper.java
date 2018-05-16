package com.jnl.boot.web.business.resource.mapper;

import com.jnl.boot.web.business.resource.entity.Resource;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper{

    Resource getResourceById(Integer id);

    List<Resource> list(Resource resource);

    int insert(Resource resource);

    int insertList(@Param("list") List<Resource> resourceList);

    int update(Resource resource);

}