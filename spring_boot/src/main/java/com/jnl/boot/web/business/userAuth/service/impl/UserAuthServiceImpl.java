package com.jnl.boot.web.business.userAuth.service.impl;

import com.jnl.boot.web.business.userAuth.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import com.jnl.boot.web.business.userAuth.entity.UserAuth;
import com.jnl.boot.web.business.userAuth.mapper.UserAuthMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("userAuthService")
public class UserAuthServiceImpl implements IUserAuthService {
    @Autowired
    private UserAuthMapper userAuthMapper;
    @Override
    public UserAuth getUserAuthById(Integer id){
        return userAuthMapper.getUserAuthById(id);
    }

    @Override
    public List<UserAuth> list(UserAuth userAuth){
        return userAuthMapper.list(userAuth);
    }

    @Override
    public int insert(UserAuth userAuth){
        return userAuthMapper.insert(userAuth);
    }

    public int update(UserAuth userAuth){
        return userAuthMapper.update(userAuth);
    }

    @Override
    public UserAuth getUserByLoginName(String loginName) {
        UserAuth query = new UserAuth();
        query.setLoginName(loginName);
        List<UserAuth> list = this.list(query);
        if(list == null || list.isEmpty())
            return null;
        return list.get(0);
    }

}