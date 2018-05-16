package com.jnl.boot.web.business.user.service;

import com.jnl.boot.web.business.user.entity.User;
import java.util.List;

public interface IUserService{

    User getUserById(Integer id);

    List<User> list(User user);

    int insert(User user);

    int update(User user);

    User getUserByName(String userName);
}