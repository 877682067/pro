package com.jnl.boot.web.business.resourceUser.mapper;

import com.jnl.boot.web.business.resourceUser.entity.ResourceUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceUserMapper{

    ResourceUser getResourceUserById(Integer id);

    List<ResourceUser> list(ResourceUser resourceUser);

    int insert(ResourceUser resourceUser);

    int insertList(@Param("list") List<ResourceUser> resourceUserList);

    int update(ResourceUser resourceUser);

}