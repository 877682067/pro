package com.jnl.boot.web.business.userGroup.service;

import com.jnl.boot.web.business.userGroup.entity.UserGroup;
import java.util.List;

public interface IUserGroupService{

    UserGroup getUserGroupById(Integer id);

    List<UserGroup> list(UserGroup userGroup);

    int insert(UserGroup userGroup);

    int update(UserGroup userGroup);

}