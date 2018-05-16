package com.jnl.boot.web.business.user.service.impl;

import com.jnl.boot.web.business.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.user.entity.User;
import com.jnl.boot.web.business.user.mapper.UserMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> list(User user){
        return userMapper.list(user);
    }

    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }

    public int update(User user){
        return userMapper.update(user);
    }

    @Override
    public User getUserByName(String userName) {
        User query = new User();
        query.setName(userName);
        List<User> list = this.list(query);
        if(list==null || list.isEmpty())
            return null;
        return list.get(0);
    }

}