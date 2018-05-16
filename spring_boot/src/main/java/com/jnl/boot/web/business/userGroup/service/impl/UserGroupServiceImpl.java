package com.jnl.boot.web.business.userGroup.service.impl;

import com.jnl.boot.web.business.userGroup.service.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.userGroup.entity.UserGroup;
import com.jnl.boot.web.business.userGroup.mapper.UserGroupMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("userGroupService")
public class UserGroupServiceImpl implements IUserGroupService {
    @Autowired
    private UserGroupMapper userGroupMapper;
    @Override
    public UserGroup getUserGroupById(Integer id){
        return userGroupMapper.getUserGroupById(id);
    }

    @Override
    public List<UserGroup> list(UserGroup userGroup){
        return userGroupMapper.list(userGroup);
    }

    @Override
    public int insert(UserGroup userGroup){
        return userGroupMapper.insert(userGroup);
    }

    public int update(UserGroup userGroup){
        return userGroupMapper.update(userGroup);
    }

}