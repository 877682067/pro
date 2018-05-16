package com.jnl.boot.web.business.user.mapper;

import com.jnl.boot.web.business.user.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper{

    User getUserById(Integer id);

    List<User> list(User user);

    int insert(User user);

    int insertList(@Param("list") List<User> userList);

    int update(User user);

}