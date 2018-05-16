package com.jnl.boot.web.business.userAuth.service;

import com.jnl.boot.web.business.user.entity.User;
import com.jnl.boot.web.business.userAuth.entity.UserAuth;
import java.util.List;

public interface IUserAuthService{

    UserAuth getUserAuthById(Integer id);

    List<UserAuth> list(UserAuth userAuth);

    int insert(UserAuth userAuth);

    int update(UserAuth userAuth);

    UserAuth getUserByLoginName(String userName);
}