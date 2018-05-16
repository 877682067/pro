package com.jnl.boot.web.business.userGroup.mapper;

import com.jnl.boot.web.business.userGroup.entity.UserGroup;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupMapper{

    UserGroup getUserGroupById(Integer id);

    List<UserGroup> list(UserGroup userGroup);

    int insert(UserGroup userGroup);

    int insertList(@Param("list") List<UserGroup> userGroupList);

    int update(UserGroup userGroup);

}